package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveHandler {

    private static List<Course> list = new ArrayList<>(); 
    private String courseName;
    private int coursePoints;
    private Course course;

    static String filename = "courses.txt";

    public void getPointsFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/courses.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            String courseName = parts[0];
            String coursePoints = parts[1];
            double coursePointsInt = Double.parseDouble(coursePoints);
            Course course = new Course(courseName, coursePointsInt);
            System.out.println(course.getCourseName() + " " + course.getExtraPoints());

            /*
             * /
             * 
             * String lineInfo = line.split(";");
             * 
             * String courseName = lineInfo[0];
             * String coursePoints = lineInfo[1];
             * /
             */
        }
        scanner.close();
    }

    /*
     * /
     * private Collection<Course> courses = new ArrayList<>();
     * 
     * public void readFromInputStream(Input stream) {
     * this.courses = new ArrayList<>();
     * try (Scanner scanner = new Scanner(stream)) {
     * while (scanner.hasNextLine()){
     * String line = scanner.nextLine();
     * String[] details = line.split(",");
     * String courseName = details[0];
     * double coursePoints = Double.parseDouble(details[1]);
     * }
     * }
     * 
     * }
     * /
     */

    @Override
    public String toString() {
        return "{" +
                " courseName='" + getCourseName() + "'" +
                ", coursePoints='" + getCoursePoints() + "'" +
                "}";
    }

    private int getCoursePoints() {
        return coursePoints;
    }

    private String getCourseName() {
        return courseName;
    }

    public static void main(String[] args) throws FileNotFoundException {
        SaveHandler display = new SaveHandler();
        display.getPointsFromFile("courses.txt");
    }

}