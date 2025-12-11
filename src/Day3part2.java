import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3part2 {

    void main() {

        //long sumOfFakeIdsValues = 0;

        //read the txt file
        try {
            File file = new File("./src/inputsDay3.txt");
            Scanner fileReader = new Scanner(file);

            long totalJoltagePower = 0;

            while (fileReader.hasNextLine()){
                String data = fileReader.nextLine(); //scan next line
                char[] currentLine = data.toCharArray(); //recup content line en char array
                int currentLineSize = currentLine.length; //recup taille pour operations

                StringBuilder stringBuilder = new StringBuilder();

                int maxRange = 11; // last numbers of the line
                int currentBiggest = 0; //current biggest
                int indiceCurrentBiggest = 0;

                //mettre tout dans un while => tant que maxRange != 0 ? mettre +1 pour le indice current biggest sinon meme number pris

                for (int i = indiceCurrentBiggest; i < currentLineSize - maxRange; i++) {
                    //for easy manipulation (cant compare char with int etc)
                    int currentCharacterNumericValue = Character.getNumericValue(currentLine[i]);

                    if(currentCharacterNumericValue > currentBiggest){
                        currentBiggest = currentCharacterNumericValue;
                        indiceCurrentBiggest = i;
                        //i = indiceCurrentBiggest + 1; // A TESTER mais pas besoin de cette ligne ici pour le moment, plus bas maybe
                    }

//                    //faux pour le moment, on a besoin du plus grand dans toute la ligne
//                    if(currentCharacterNumericValue > currentBiggest){
//                        currentBiggest = currentCharacterNumericValue;
//                        stringBuilder.append(currentBiggest);
//                        //i = currentLineSize
//                        maxRange--;
//                    }
                }



            }

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

    }

}
