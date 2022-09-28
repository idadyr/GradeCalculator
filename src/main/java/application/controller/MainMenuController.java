package application.controller;

import application.model.ReadAndWrite;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;

import java.io.IOException;

import application.model.IWriteToFile;

public class MainMenuController extends Controller {

    @FXML
    private Button loginButton, registerButton; 
    @FXML
    private TextField usernameInput; 
    @FXML 
    private Text loggedInUser; 


    private IWriteToFile userFile = new ReadAndWrite(); 
    private IWriteToFile latestUsersFile = new ReadAndWrite(); 
    

    @FXML
    private void initialize(){
        loginButton.setOnAction(event -> loginPerson());
        registerButton.setOnAction(event -> registerPerson()); 
    }
    
    
    private void registerPerson(){

        String userName = usernameInput.getText(); 

        try { 
            if (!userName.equals(null) & userName.matches("[a-zA-Z]*$") & !userFile.checkIfFileLineEquals("src/users.txt", userName) ){ // hvis fil ikke inneholder username
                latestUsersFile.addUserToFile("src/latestUsers.txt", userName);
                userFile.addUserToFile("src/users.txt", userName); 
                changeScene("Calculator.fxml");
            
        } else{
            showErrorMessage("Check this: username cannot contain anything but letters or this username might already excist! Choose another name only containing letters!");
        }
    }   catch (IOException e) {
            showErrorMessage("errorMessage"); 
        
        }
 
    }
    
    private void showErrorMessage(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An Error has ocurred");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    
    
    private void loginPerson() {
        String userName = usernameInput.getText(); 
        try {
            if (userFile.checkIfFileLineEquals("src/users.txt", userName)){
                latestUsersFile.addUserToFile("src/latestUsers.txt", userName);
                changeScene("Calculator.fxml");
            }else{
                showErrorMessage("This username does not exist! Register user!");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    
}