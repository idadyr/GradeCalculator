package application.controller;
import application.model.SaveHandler;
import application.model.UserProfile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainMenuController extends Controller {
    @FXML
    private Button loginButton; 
    @FXML 
    private Button registerButton; 
    @FXML
    private TextField userNameInput; 
    @FXML 
    Text loggedInUser; 


    

    @FXML
    public void initialize(){
        loginButton.setOnAction(event -> test());

/*/
        SaveHandler saveHandler = new SaveHandler();
		try {
			saveHandler.loadUserData("UserData", UserProfile.Users);
			System.out.println(UserProfile.Users.toString());
			saveHandler.loadToOuterMap("UserGrades", UserProfile.outerMap);
			System.out.println(UserProfile.userProfiles.toString());
		} catch (Exception e) {
			loggedInText.setText("Something went wrong loading data!");
		}
		
		if(loggedInUser != null) {
			loggedInText.setText("Velkommen " + loggedInUser);
			usernameInput.setText(loggedInUser);
		}

			System.out.println(UserProfile.userProfiles);
			for(int i = 0; i<UserProfile.userProfiles.size(); i++) {
				UserProfile userProfile = (UserProfile) UserProfile.userProfiles.get(i);
				System.out.println(userProfile.getUsernameInput() + " har hashmap: " + userProfile.getUserGrades());
			}
/*/
    }

    public void test() {
        changeScene("Calculator.fxml");

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
