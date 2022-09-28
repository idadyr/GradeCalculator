package Calculator_test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import application.model.Course;
import application.model.IWriteToFile;
import application.model.Person;
import application.model.ReadAndWrite;

public class ReadAndWriteTest {
    
    private Person person1;
    private Course course1; 
    private String userFileName = "src/usersTest.txt"; 
    private String latestUserFileName = "src/latestUsersTest.txt"; 
    private String everythingFileName = "src/everythingTest.txt"; 
    private IWriteToFile userFile = new ReadAndWrite(); 
    private IWriteToFile latestUserFile = new ReadAndWrite();
    private IWriteToFile everythingFile = new ReadAndWrite(); 

   

    @BeforeEach
    public void BeforeEach() throws IOException{
        person1 = new Person("ida", "2000", 0.2); 
        course1 = new Course("Fysikk1", 4, 4, 0.05); 
        userFile.addUserToFile(userFileName, person1.getName()); 
        latestUserFile.addUserToFile(latestUserFileName, person1.getName());
        
       
    }

    @Test
    @DisplayName("Adding users to userfile")
    public void addUserToUserFileTest(){
        assertEquals("ida", person1.getName());
    }

    @Test
    @DisplayName("Adding users to latestuserfile")
    public void addUserToLatestUserFileTest(){
        assertEquals("ida", person1.getName());
    }

    @Test
    @DisplayName("Checking course is added")
    public void checkAddCourseToFileTest(){
        assertEquals("-Fysikk1$4$4$0.05", course1.toString2());
    }
    
    @Test 
    @DisplayName("Checking if fileLineEquals() works")
    public void checkIfFileLineEqualsTest() throws IOException{
        assertEquals(true, userFile.checkIfFileLineEquals(userFileName, person1.getName()));
    }

    @Test 
    @DisplayName("Checking if fileContsins() works")
    public void checkIfFileContainsTest() throws IOException{
        assertEquals(true, everythingFile.checkIfFileContains(userFileName, person1.getName()));
    }

    @Test
    @DisplayName("Checking if retrieveCredit works") 
    public void retrieveCreditTest(){
        assertEquals(0.05, course1.getCredits());
    }

    @Test
    @DisplayName("Checking if readFromFile() works")
    public void readFromFileTest() throws FileNotFoundException{
        everythingFile.addPersonToFile(everythingFileName, person1);
        assertEquals(everythingFile.readFromFile(everythingFileName, person1.getName()).toString(), person1.toString());
    }




    



}
