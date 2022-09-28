package application.model;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public interface IWriteToFile  {

   public Person readFromFile(String fileName, String name) throws FileNotFoundException; 
   public void addUserToFile(String filName, String usernameInput) throws IOException; 
   public double retrieveCredit(String fileName, String courseName) throws FileNotFoundException; 
   public boolean checkIfFileLineEquals(String fileName, String userName) throws IOException; 
   public boolean checkIfFileContains(String fileName, String userName) throws IOException; 
   public String getLatestUsers(String fileName) throws FileNotFoundException; 
   public void addCourseToFile(String fileName, Course course) throws FileNotFoundException; 
   public void addPersonToFile(String fileName, Person person) throws FileNotFoundException; 
   public List<String> addToComboBox() throws FileNotFoundException;
  


   
}


    

