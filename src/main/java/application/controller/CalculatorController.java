package application.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class CalculatorController extends Controller{
    @FXML
    ComboBox<String> courseBox;
    @FXML
    Button returnButton;
    @FXML 
    ComboBox<Integer> gradeBox; 
    @FXML
    ComboBox<String> ageBox; 
    @FXML
    Button calculateButton; 
    @FXML
    ComboBox<Integer> examGrade; 
    @FXML
    ComboBox<Integer> extraPointsBox; 
    @FXML 
    Button addCourseButton; 
    @FXML 
    ComboBox<Integer> coursePoints; 

    // Initialize FXML
    @FXML
    public void initialize() throws IOException {
        returnButton.setOnAction(event -> test());
        // Read items from txt File
        BufferedReader br = new BufferedReader(new FileReader("src/courses.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
           

            while (line != null) {
                // Add Item
                String[] output = line.split(";"); // lager en ny variabel for å fjerne realfagpoengene 
                String linje = output[0]; 
                courseBox.getItems().addAll(linje);  
                
                sb.append(linje);
                line = br.readLine();
            }
        } finally {
            br.close();
        }

        // Default Selection first item
        courseBox.getSelectionModel().select(0);

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

        examGrade.getItems().add(1);
        examGrade.getItems().add(2);
        examGrade.getItems().add(3);
        examGrade.getItems().add(4);
        examGrade.getItems().add(5);
        examGrade.getItems().add(6);


    }

    

    /*
     * /
     * List<String> myList = Files.lines(path).collect(Collectors.toList());
     * comboBox.setItems(FXCollections.observableArrayList(myList));
     * 
     * @FXML
     * public void initialize() throws IOException {
     * returnButton.setOnAction(event -> test());
     * try {
     * 
     * BufferedReader br = new BufferedReader(new FileReader("course.txt"));
     * StringBuilder sb = new StringBuilder();
     * String line = br.readLine();
     * 
     * while (line != null) {
     * // Add Item
     * courseBox.getItems().add(line);
     * 
     * sb.append(line);
     * line = br.readLine();
     * }
     * br.close();
     * } catch (IOException e) {
     * System.out.println("Don t find file");
     * }
     * 
     * }
     * /
     */
    public void test() {
        changeScene("Ui.fxml");
    }

}
