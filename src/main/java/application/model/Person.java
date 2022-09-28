package application.model;



import java.time.Year;
import java.util.ArrayList;

import java.util.List;

public class Person {

    private String name;
    private String selectedAge;
    private double extraPoints;
    private List<Course> courseList = new ArrayList<Course>();
    private double agePoints;


    public Person(String name) {
       this.name = name; 
    }
    
    public Person(String name, String selectedAge, double extraPoints, List<Course> courseList) {
        this(name, selectedAge, extraPoints);
        this.courseList = courseList;
    }

    public Person(String name, String selectedAge, double extraPoints) {
        isValidName(name);
        this.name = name; 
        this.selectedAge = selectedAge;
        this.extraPoints = extraPoints;
        this.courseList = new ArrayList<Course>();

    }

    public Person(String name, double agePoints, double extraPoints){
        isValidName(name);
        this.name = name; 
        this.agePoints = agePoints;
        this.extraPoints = extraPoints;
        this.courseList = new ArrayList<Course>();
    }

    public Person(String name, double agePoints, double extraPoints, List<Course> courseList){
        isValidName(name);
        this.name = name; 
        this.agePoints = agePoints;
        this.extraPoints = extraPoints;
        this.courseList = new ArrayList<Course>();
    }
    

    public void addCourse(Course course) {
        courseList.add(course);
     

    }


    public double getAgePoints() {
        agePoints = 0;
        int currentYear = Year.now().getValue();
        int year = Integer.parseInt(selectedAge.substring(0, 4));
        int diff = currentYear - year;
        if (diff == 19) {
            agePoints = 0;
        } else if (diff == 20) {
            agePoints = 0.2;
        } else if (diff == 21) {
            agePoints = 0.4;
        } else if (diff == 22) {
            agePoints = 0.6;
        } else {
            agePoints = 0.8;
        }

        return agePoints;

    }
  

    public String getSelectedAge() {
        return this.selectedAge;
    }

    public void setSelectedAge(String selectedAge){
        this.selectedAge = selectedAge; 
    }

    public double getExtraPoints() {
        return this.extraPoints;
    }

    public List<Course> getCourseList() {
        return new ArrayList<>(courseList); // lager kopi
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isValidName(String userName) {
        if (userName.matches("[a-zA-Z]*$")) {
            setName(userName);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        
        return "\n" + name + "%" + selectedAge + "%" + extraPoints; 
    }





}
