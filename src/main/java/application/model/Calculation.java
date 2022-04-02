package application.model;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Calculation {

    double avg;
    int karakter = 0; 


    public Calculation() {

    }

    // her legger jeg sammen alle karakterene
/*/
    public String Calculate(List<Integer> grades) {
		String result = "";


        for (int i = 0; i < grades.size(); i++) {
			if(grades.get(i).equals("1")) {
				System.out.println("1");
			} else if(grades.get(i).equals("2")) { 
				karakter += 2;
			} else if(grades.get(i).equals("3")) {
				karakter += 3;
			} else if(grades.get(i).equals("4")) {
				karakter += 4;
			}
			else if(grades.get(i).equals("5")) {
				karakter += 5;
			}
            else if(grades.get(i).equals("6")) {
				karakter += 6;
			}
			else {
				karakter += 0;
			}
			
		}
    }
/*/
    //her skal jeg regne ut snittet før ekstrapoeng brukeren må velge akkuratt 16 fag

    public Snitt(){
        avg = karakter/16; 
    }
    






    

