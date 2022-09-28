package Calculator_test; 

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import application.model.Course;
import application.model.GradeCalculator;
import application.model.Person; 



public class GradeCalculatorTest {
    
    Person personA; 
    GradeCalculator gradeCalculatorA; 
    Course courseA;
    Course courseB;



    @BeforeEach
    public void setup(){
        try {
            courseB = new Course("ITGK", 0, 8, 2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        try {
            courseA = new Course("Informasjonsteknologi 1", 5, 0.5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        personA = new Person("ida","2000",0.2); 
        gradeCalculatorA = new GradeCalculator(personA); 
    }
    
    @Test 
    @DisplayName("Teste calculate")
    public void testCalculate(){
        gradeCalculatorA.calculateAverage(); 
        personA.addCourse(courseA);
        Assertions.assertEquals(1, personA.getCourseList().size());  // tester om faget har blitt lagt til i courselist 
        try {
            Assertions.assertEquals("5,85", gradeCalculatorA.calculate());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        

    }

   

    
}



