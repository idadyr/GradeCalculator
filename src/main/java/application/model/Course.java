package application.model;

public class Course {

    private String courseName;
    private int courseGrade;
    private double extraPoints;
    static String filename = "courses.txt"; 


    public Course(String courseName, double extraPoints){
        this.courseName = courseName;
        this.extraPoints = extraPoints;
    }
    
    public Course(String courseName){
        this.courseName = courseName;
    }

    public Course(String courseName, double extraPoints, int courseGrade){
        this.courseName = courseName;
        this.extraPoints = extraPoints;
        this.courseGrade = courseGrade;
    }


    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseGrade() {
        return this.courseGrade;
    }

    public void setCourseGrade(int courseGrade) {
        this.courseGrade = courseGrade;
    }

    public double getExtraPoints() {
        return this.extraPoints;
    }

    public void setExtraPoints(double extraPoints) {
        this.extraPoints = extraPoints;
    }
    





   


public static void main(String[] args) {
    
        
    }
        
}





