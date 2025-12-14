import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3part2 {

    void main() {

        //read the txt file
        try {
            File file = new File("./src/inputsDay3.txt");
            Scanner fileReader = new Scanner(file);

            long totalJoltagePower = 0;

            while (fileReader.hasNextLine()){
                String data = fileReader.nextLine(); //scan next line
                char[] currentLine = data.toCharArray(); //recup content line en char array
                int currentLineSize = currentLine.length; //recup taille pour operations

                //reset all of those after each line
                StringBuilder stringBuilder = new StringBuilder();
                int maxRange = 11; // last numbers of the line
                int indexCurrentBiggest = 0;
                int currentBiggest = 0; //current biggest in the RANGE (we need to reset at every step and not line, put here for easy access)

                //chaque boucle du while ==> une STEP dans la recherche du nombre entre index + 1 et l'index de (taille max - max range)
                //doit s'executer 12 fois par ligne si tout va bien :)
                while (maxRange != - 1){


                    //boucle dynamique pour trouver UN nbre (la 1ere occurence du plus grand nbre de chaque étape) dans la range
                    for (int i = indexCurrentBiggest; i < (currentLineSize - maxRange); i++) {

                        //for easy manipulation (cant compare char with int etc)
                        int currentCharacterNumericValue = Character.getNumericValue(currentLine[i]);

                        //if we find a bigger number in the range we set, we keep that value and index instead
                        if (currentCharacterNumericValue > currentBiggest) {
                            currentBiggest = currentCharacterNumericValue;
                            indexCurrentBiggest = i + 1;
                        }
                        //System.out.println("loop nb:" + i + ". current biggest in range: " + currentBiggest + " ,at index: " + indexCurrentBiggest);
                    }

                    //une fois qu'on a trouvé le nb le plus grand de la range, on l'add au SB, réduit la range et reset le plus grand nb actuel
                    stringBuilder.append(currentBiggest);

                    //System.out.println("current biggest at the end of the step == " + currentBiggest);
                    currentBiggest = 0; //reset
                    //pas besoin incrementer i, il s'incremente tout seul a la fin de la boucle
                    maxRange--;
                }

                totalJoltagePower += Long.parseLong(stringBuilder.toString());
                System.out.println("current state of the sb at the end of the line = " + stringBuilder);
            }

            System.out.println("final result = " + totalJoltagePower);

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

    }

}
