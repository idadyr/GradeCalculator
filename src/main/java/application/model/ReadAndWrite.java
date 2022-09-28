package application.model;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite implements IWriteToFile {

    private String[] splitted2 = null;
    private double credits = 0;
    private Person person = null;
    private Course course; 

    @Override
    public Person readFromFile(String fileName, String name) throws FileNotFoundException {

        try {

            File file = new File(fileName);
            String line = null;
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.contains("%")) {
                    String[] splitted = line.split("%");
                    int currentYear = Year.now().getValue();
                    String personName = splitted[0];
                    if (personName.equals(name)) {

                        String personAge = splitted[1];
                        double personAgePoints = 0;
                        double personExtraPoints = Double.parseDouble(splitted[2]);
                        int year = Integer.parseInt(personAge.substring(0, 4));
                       

                        int diff = currentYear - year;
                        if (diff == 19) {
                            personAgePoints = 0;
                        } else if (diff == 20) {
                            personAgePoints = 0.2;
                        } else if (diff == 21) {
                            personAgePoints = 0.4;
                        } else if (diff == 22) {
                            personAgePoints = 0.6;
                        } else {
                            personAgePoints = 0.8;
                        }

                        person = new Person(personName, personAgePoints, personExtraPoints);
                        person.setSelectedAge(personAge);
                      
                    }

                } else if (line.contains("$") && person != null) {

                    splitted2 = line.split("-");
                   
                    String string = splitted2[1].toString();
                    
                    String[] splitted3 = string.split("\\$");
                   

                    for (int i = 1; i < splitted2.length; i++) {
                       
                        course = new Course(splitted2[i].split("\\$")[0],
                                Integer.parseInt(splitted2[i].split("\\$")[1]),
                                Integer.parseInt(splitted2[i].split("\\$")[2]),
                                Double.parseDouble(splitted2[i].split("\\$")[3]));

                        person.addCourse(course);
                       
                    }
                    if (person.getName().equals(name)) {
                        return person;
                    }

                }

            }
            scanner.close(); 
           
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
        return null;

    }



    @Override
    public void addUserToFile(String fileName, String usernameInput) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true); // Set true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(usernameInput); // New line
        printWriter.close();
    }

    @Override
    public boolean checkIfFileLineEquals(String fileName, String userName) throws FileNotFoundException {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if (line.equals(userName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getLatestUsers(String fileName) throws FileNotFoundException {
        String latestUserName = null;
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                latestUserName = scanner.nextLine();
               
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (latestUserName.isBlank()) {
            throw new IllegalArgumentException("Something went wrong");
        }
        return latestUserName;

    }

   
    
     @Override
    public void addCourseToFile(String fileName, Course course) throws
     FileNotFoundException {
    
     try (FileWriter fileWriter = new FileWriter(fileName, true)) {
     PrintWriter printWriter = new PrintWriter(fileWriter);

      printWriter.print(course.toString2());
      printWriter.close();
      
      } catch (IOException e) {

      e.printStackTrace();
     
      }
      }
    @Override
    public void addPersonToFile(String fileName, Person person) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(person.toString()); 
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean checkIfFileContains(String fileName, String userName) throws IOException {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            int lineNum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineNum++;
                if (line.contains(userName)) {
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public double retrieveCredit(String fileName, String courseName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");

            if (parts[0].equals(courseName)) {
                credits = Double.parseDouble(parts[1]);
               

            }
        }

        scanner.close();
        return credits; 

    }
    @Override
    public List<String> addToComboBox(){
        List<String> choices = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new FileReader("src/courses.txt"))) {
        
        try {
            
        
            String line = br.readLine();

            while (line != null) {

                String[] output = line.split(";"); 
                String line1 = output[0];
                

                choices.add(line1);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return choices;
}





}
