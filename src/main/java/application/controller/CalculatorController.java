package application.controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import application.model.Course;
import application.model.GradeCalculator;
import application.model.IWriteToFile;
import application.model.Person;
import application.model.ReadAndWrite;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class CalculatorController extends Controller {


    private List<String> selectedCourses = new ArrayList<>();
    private IWriteToFile latestUsersFile = new ReadAndWrite();
    private Person person;
    private IWriteToFile everything = new ReadAndWrite();
    private ReadAndWrite raw = new ReadAndWrite(); 

    @FXML 
    private AnchorPane rootPane; 
    @FXML
    private ComboBox<String> courseBox, ageBox;;
    @FXML
    private Button returnButton, addCourseButton, calculateButton, saveUserButton;
    @FXML
    private ComboBox<Integer> gradeBox, examGradeBox;
    @FXML
    private ComboBox<Double> extraPointsBox;
    @FXML
    private TextField usernameInput;
    @FXML
    private ListView<String> courseView;
    @FXML 
    private Button loadButton; 
   
    @FXML
    private void initialize() throws IOException {

        setComboBox(); 

        this.person = new Person(latestUsersFile.getLatestUsers("src/latestUsers.txt"));

        returnButton.setOnAction(event -> returnToMain());
        addCourseButton.setOnAction(event -> addSelectedCourse());
       
        calculateButton.setOnAction(event -> calculate());
        saveUserButton.setOnAction(event -> addPersonToFile());
        loadButton.setOnAction(event -> loadData());
        courseBox.setDisable(true);
        gradeBox.setDisable(true); 
        examGradeBox.setDisable(true);
        addCourseButton.setDisable(true);
        
        String userName = latestUsersFile.getLatestUsers("src/latestUsers.txt");
        if (everything.checkIfFileContains("src/everything.txt", userName)) {
            ageBox.setDisable(true);
            extraPointsBox.setDisable(true); 
            saveUserButton.setDisable(true);
            calculateButton.setDisable(false);
            
        }

       
        
    }
        private void setComboBox(){

        courseBox.getItems().addAll(raw.addToComboBox());
    

        gradeBox.getItems().add(0);
        gradeBox.getItems().add(1);
        gradeBox.getItems().add(2);
        gradeBox.getItems().add(3);
        gradeBox.getItems().add(4);
        gradeBox.getItems().add(5);
        gradeBox.getItems().add(6);

        ageBox.getItems().add("1999 eller eldre");
        ageBox.getItems().add("2000");
        ageBox.getItems().add("2001");
        ageBox.getItems().add("2002");
        ageBox.getItems().add("2003");

        examGradeBox.getItems().add(0);
        examGradeBox.getItems().add(1);
        examGradeBox.getItems().add(2);
        examGradeBox.getItems().add(3);
        examGradeBox.getItems().add(4);
        examGradeBox.getItems().add(5);
        examGradeBox.getItems().add(6);

        extraPointsBox.getItems().add(0.0);
        extraPointsBox.getItems().add(0.1);
        extraPointsBox.getItems().add(0.2);


    }

    private void setComboBoxValues(){
    
        examGradeBox.getSelectionModel().clearSelection();
    }
    

    
    private void addSelectedCourse() {
        try {
            
            if(examGradeBox.getSelectionModel().getSelectedItem() == null){
                Course course = new Course(courseBox.getSelectionModel().getSelectedItem(),
            gradeBox.getSelectionModel().getSelectedItem(), 0); 
                everything.addCourseToFile("src/everything.txt", course);
                person.addCourse(course);
                courseView.getItems().add(course.getCourseName() + " credits: " + course.getCredits() + " grade:  " + 
                + course.getGrade() + " exam: " + course.getExamGrade());
            }else{
                Course courseExam = new Course(courseBox.getSelectionModel().getSelectedItem(),
                    gradeBox.getSelectionModel().getSelectedItem(),
                    examGradeBox.getSelectionModel().getSelectedItem());
                everything.addCourseToFile("src/everything.txt", courseExam);
                person.addCourse(courseExam);
                setComboBoxValues();
                courseView.getItems().add(courseExam.getCourseName() + " credits: " + courseExam.getCredits() + " grade:  " + 
                + courseExam.getGrade() + " exam: " + courseExam.getExamGrade());
              
            }
            
            
            selectedCourses.add(courseBox.getSelectionModel().getSelectedItem());
            courseBox.getItems().removeAll(selectedCourses);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    
    private void calculate() {
        try {
            GradeCalculator gradeCalculator = new GradeCalculator(person);
            showDataMessage("Your GPA is: " + gradeCalculator.calculate());
            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }

    }
    private void showDataMessage(String dataMessage) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Information");
        alert.setContentText(dataMessage);
        alert.showAndWait();
    }

    private void showErrorMessage(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An Error has ocurred");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    
    private void addPersonToFile() {
        loadButton.setDisable(true);
        saveUserButton.setDisable(true);
        courseBox.setDisable(false);
        gradeBox.setDisable(false); 
        examGradeBox.setDisable(false);
        addCourseButton.setDisable(false);
        
        
        try {
            String userName = latestUsersFile.getLatestUsers("src/latestUsers.txt");
            this.person = new Person(userName,
            ageBox.getSelectionModel().getSelectedItem(), extraPointsBox.getSelectionModel().getSelectedItem());
  
            if (!everything.checkIfFileContains("src/everything.txt", userName)) {
                everything.addPersonToFile("src/everything.txt", person);
                
            } else {
        
                showErrorMessage("You already saved your user information \n You are only supposed to save your user information once!");
               
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    
    private void returnToMain() {
        changeScene("Ui.fxml");
    }

    
    
    private void loadData(){
        
        try {
            this.person = everything.readFromFile("src/everything.txt", person.getName());
            if(this.person == null){ 
                showErrorMessage("You have no data to load. Please register a new user");
            }
            for (Course course : person.getCourseList()) {
                courseView.getItems().add(course.getCourseName() + " extrapts: " + course.getCredits() + " grade:  " + 
                + course.getGrade() + " exam: " + course.getExamGrade()); 
                
            }
            
        } catch (IOException e) {
           
            e.printStackTrace();
        }

    }


}
