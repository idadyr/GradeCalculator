package Calculator_test;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import application.model.Person;

public class PersonTest {

    private Person person1;
    private Person person2;  
    private Person person3; 

    


    @BeforeEach
    public void setup(){
        person1 = new Person("ida", 0.2, 0.2); 
        person2 = new Person("michelle", "2002", 0.0); 

    }

    @Test
    @DisplayName("")
    public void TestAgeInput(){
        assertEquals("ida", person1.getName());
        assertEquals(0.2, person2.getAgePoints());
        Assertions.assertFalse(false, person3.getName());
    }

}
