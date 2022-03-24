package application.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CalculatorController {
    @FXML
    private Button karakterButton; 

    @FXML 
    public void initialize(){
        karakterButton.setOnAction(event -> test());
      
    }
    public void test(){
        System.out.println("hallaballa");
    }

    
}
