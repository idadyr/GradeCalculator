package application.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private Button loginButton; 

    public Controller() {
        // tom konstruktør foreløpig
    }

    @FXML
    public void initialize(){
        loginButton.setOnAction(event -> test());

    }

    public void test() {
        System.out.println("hei");

    }

    public void handleButtonClick(){
        System.out.println("");
    }

    

    /*/

    for (String string : args) {
        try{
            Course course = new Course(courseName, extraPoints)
        }
            catch {
                Course course = new Course(courseName)
            }

        }
        /*/
        
}
