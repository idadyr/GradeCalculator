package application.model;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.controller.CalculatorController;
import application.controller.MainMenuController;

public class UserProfile {

	// Her skal verdiene fra brukeren legges inn
	private String userNameInput;
	private boolean isLoggedIn = false;
	private String registerUser;
	private CalculatorController extraPointsBox;

	ArrayList<ArrayList<String>> UserCourses = new ArrayList<ArrayList<String>>();
	private CalculatorController ageBox;
		


	
	public UserProfile(String userNameInput, CalculatorController ageBox, CalculatorController extraPointsBox) {
		this.userNameInput = userNameInput; 
		this.ageBox = ageBox; 
		this.extraPointsBox = extraPointsBox; 

	}

}



/*/

	
	static HashMap<String, HashMap<String, String>> outerMap = new HashMap<>();   //2d hashmap
	static HashMap<String, String> Courses = new HashMap<>();
	HashMap<String, String> course;
	public static List<Object> userProfiles = new ArrayList<Object>();
	public List<Object> courseBox;
	public List<Object> gradeBox; 
	public List<Object> examGrade; 
	public CalculatorController ageBox; 
	
	

	public UserProfile(String userNameInput, HashMap<String, String> gradeBox, boolean isLoggedIn) {
		validUsername(userNameInput);
		this.userGrades = new HashMap<String, String>();
		this.userNameInput = userNameInput;
		this.setLoggedIn(false);
		this.courseBox = new ArrayList<Object>(); 
		userProfiles.add(this);
	}


	private void setLoggedIn(boolean b) {
	}


	private void validUsername(String usernameInput2) {

	}

	private void isLoggedIn(String userNameInput) {
		BufferedReader br = openFile("scr/users.txt");
		try {
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				if (line.equals(userNameInput))
					System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Du er ikke logget inn");
		}
	}
	/*/
/*/
	private BufferedReader openFile(String string) {
		return null;
	}

/*/

	
/*/ Her er om jeg skal skrive til fil, men prøver først å bruke hashmap
	public class WriteToFile {
		  try {
			FileWriter myWriter = new FileWriter("scr/users.txt");
			myWriter.write(userNameInput);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
	}
/*/
	