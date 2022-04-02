package application.model;

import java.io.FileWriter;

public class ReadAndWrite implements WriteToFile {

    @Override
    public boolean writeToFile(String userNameInput, int ageBox) {
        FileWriter fWriter = new FileWriter("scr/users.txt");
        fWriter.write(userNameInput);

        return false; 
    }

    @Override
    public boolean readFromFile() {
        // TODO Auto-generated method stub
        return false;
    }

}
