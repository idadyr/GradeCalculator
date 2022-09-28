package application.model;


import java.io.FileNotFoundException;

public class Course {

    private String courseName;
    private double credits;
    private int grade;
    private int examGrade;
    private ReadAndWrite raw = new ReadAndWrite();

    public Course(String courseName, int grade, int examGrade) throws FileNotFoundException {
        this.courseName = courseName;
        retrieveCredits();
        this.grade = grade;
        this.examGrade = examGrade;

    }
    public Course(String courseName, int grade){
        this.courseName = courseName;
        this.grade = grade;

    }

    public Course(String courseName, int grade, double credits) throws FileNotFoundException {
        this.courseName = courseName;
        this.grade = grade;
        this.credits = credits;
        retrieveCredits();

    }

    public Course(String courseName, int grade, int examGrade, double credits) throws FileNotFoundException {
        this.courseName = courseName;
        this.grade = grade;
        this.examGrade = examGrade;
        retrieveCredits();
        this.credits = credits;

    } 
   

    public void retrieveCredits() throws FileNotFoundException{
        this.credits = raw.retrieveCredit("src/courses.txt", courseName); 

        
    }

    public String getCourseName() {
        return this.courseName;
    }

    public double getCredits() {
      
            return this.credits;

    
    }

    public int getGrade() {
        return this.grade;
    }

    public int getExamGrade() {
        return this.examGrade;
    }

    @Override
    public String toString() {
        return this.getCourseName();
    }

    public String toString2() {
        return "-" + courseName + "$" + grade + "$" + examGrade + "$" + credits;
    }

}
