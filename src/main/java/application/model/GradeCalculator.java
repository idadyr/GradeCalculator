package application.model;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class GradeCalculator {

  
    private Person person;
    private double avg; 
    private double snitt; 


    public GradeCalculator(Person person) {
        this.person = person;
      
    }

    public double calculateAverage() {


        avg = 0;
        int sum = 0;

    
        for (Course course  : person.getCourseList()) {
            
            sum += course.getGrade(); // +1
    
        }
        if((person.getCourseList() == null)||(person.getCourseList().size()==0)) {
            avg = 0;
        }
        else{
            avg = sum/person.getCourseList().size(); 
        }
        
       return avg;
    }

    public String calculate() throws FileNotFoundException {
        double avg = calculateAverage(); 
        double agePoints = person.getAgePoints(); 
        double totalCredits = 0; 
        for (Course course  : person.getCourseList()){
            totalCredits += course.getCredits();
            
        }
        if(totalCredits >= 0.2){
            totalCredits = 0.2; 
        }
        
        snitt = avg + agePoints + person.getExtraPoints() + totalCredits; 
        DecimalFormat ft = new DecimalFormat("#.####");
       
        return ft.format(snitt); 
    }

}
