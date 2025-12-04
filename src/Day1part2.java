import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1part2 {

    void main() {

        int currentDialPosition = 50; //default position of the dial is 50, we use current to change it easily
        int maxDialPosition = 100; //max pos is 99, we use 100 for modulo and then goes back to 0 if we increment from 99
        int occurencesOfDialShowingZero = 0; //part 2 => we count the amount of times the dial showed 0 even during the operation

        System.out.println("starting here, default pos : " + currentDialPosition);

        //read the txt file
        try{
            File file = new File("./src/inputs.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()){
                String data = fileReader.nextLine(); //scan next line
                char[] currentLine = data.toCharArray(); //recup content line en char array
                int sizeOfCurrentLine = currentLine.length; //recup taille pour operations

                StringBuilder currentNumberToAddString = new StringBuilder();

                //on recup le contenu apres la lettre R ou L (nombre qu'on va devoir additionner ou soustraire)
                for (int i = 1; i < sizeOfCurrentLine; i++) { //on recupère le contenu après la lettre de base
                    currentNumberToAddString.append(currentLine[i]);
                }

                int currentNumberToAdd = Integer.parseInt(String.valueOf(currentNumberToAddString));

                System.out.println("before the operation, nb of zeroes seen:" + occurencesOfDialShowingZero);

                //regarder si R ou L, prendre le nombre et faire l'opération ensuite
                if(currentLine[0] == 'R'){ //R, increment
                    System.out.println("R => current position: " + currentDialPosition + ". number to add: " + currentNumberToAdd);
                    currentDialPosition = (currentDialPosition + currentNumberToAdd); //% maxDialPosition;
                    while(currentDialPosition > 99){
                        System.out.println("dans le while, current dial position:" + currentDialPosition);
                        currentDialPosition = currentDialPosition - 100;
                        occurencesOfDialShowingZero++;
                    }
                } else { //L, decrement
                    System.out.println("L => current position: " + currentDialPosition + ". number to substract : " + currentNumberToAdd);
                    boolean startingPosIsZero = currentDialPosition == 0;
                    currentDialPosition = (currentDialPosition - currentNumberToAdd); //% maxDialPosition;

                    //on vérifie si c'est  =>
                    //soit INFERIEUR a 0, si oui on régle le compteur et on incrémente le nb de zero vus
                    //soit EGAL 0 => on incrémente le nb de zero vus
                    //(si sup a zero, on ne fait rien (osef))
                    if (currentDialPosition < 0) {
                        //not the best way of doing it but since starting pos == zero, with the code i did, it will increment the counter of zeroes by
                        //one each time we have to go from 0 - 1 => 99, we then keep track if the dial was on 0 to not increment twice instead of one.
                        if(startingPosIsZero)
                            occurencesOfDialShowingZero--;
                        while (currentDialPosition < 0) {
                            currentDialPosition = currentDialPosition + 100;
                            System.out.println("dans le while, current dial position:" + currentDialPosition);
                            occurencesOfDialShowingZero++;
                        }
                        if(currentDialPosition == 0) //check if we let it on 0 at the end after the operations
                            occurencesOfDialShowingZero++;
                    } else if (currentDialPosition == 0){
                        occurencesOfDialShowingZero++;
                    }
                }

                System.out.println("after operation: position = " + currentDialPosition + ". nb of zeroes seen: " + occurencesOfDialShowingZero);
                System.out.println("");
            }
        } catch (FileNotFoundException e){
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

        System.out.println("occurences of Zero : " + occurencesOfDialShowingZero);

    }

}
