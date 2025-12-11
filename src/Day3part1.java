import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3part1 {

    void main() {

        //long sumOfFakeIdsValues = 0;

        //read the txt file
        try {
            File file = new File("./src/inputsDay3.txt");
            Scanner fileReader = new Scanner(file);
            //String line = fileReader.nextLine();

            long totalJoltagePower = 0;

            while (fileReader.hasNextLine()){
                String data = fileReader.nextLine(); //scan next line
                char[] currentLine = data.toCharArray(); //recup content line en char array
                int currentLineSize = currentLine.length; //recup taille pour operations

                StringBuilder currentNumberToAddString = new StringBuilder();

                int number1 = 1;
                int number2 = 1;
                System.out.println("LINE =>  " + data);
                System.out.print("---number1 " + number1);
                System.out.print(", number2 " + number2 + "---");
                System.out.println();

                //arranger souci valeur ascii (number1 = currentLine[i]; => valeur ascii)

                //commencer par la fin => plus facile pour gérer le nombre ?
                for (int i = 0; i < currentLineSize - 1; i++) { // -1 => pas besoin check dernier si il est plus grand que le num 1 mais check num2
                    System.out.println();
                    System.out.print("current number == " + currentLine[i] );
                    System.out.print(". number1 = " + number1);
                    System.out.print(", number2 = " + number2);
                    System.out.println();
                    if(Character.getNumericValue(currentLine[i]) > number1){
                        //reset number 2 if currentLine[i] +1 != null
                        //if(currentLine[i + 1] != 0){
                        System.out.print("cas 1 => Character.getNumericValue(currentLine[i]) = " + Character.getNumericValue(currentLine[i]));

                        number1 = Character.getNumericValue(currentLine[i]);
                            //number1 = Integer.parseInt(currentLine[i]);
                        number2 = Character.getNumericValue(currentLine[i + 1]);
                        //}
                        System.out.print(". number1 = " + number1);
                        System.out.print(", number2 = " + number2);
                        System.out.println();

                    } else if (Character.getNumericValue(currentLine[i]) > number2){
                        System.out.print("cas 2 => Character.getNumericValue(currentLine[i]) = " + Character.getNumericValue(currentLine[i]));

                        number2 = Character.getNumericValue(currentLine[i]);
                        System.out.print(". number1 = " + number1);
                        System.out.print(", number2 = " + number2);
                        System.out.println();
                    }

                }
                //verifier dernier char de la ligne (on l'avait skip pour ne pas avoir de out of bonds)
                if(Character.getNumericValue(currentLine[currentLineSize - 1]) > number2)
                    number2 = Character.getNumericValue(currentLine[currentLineSize - 1]);

                currentNumberToAddString.append(number1);
                System.out.print("number1 = " + number1);
                currentNumberToAddString.append(number2);
                System.out.print(", number2 = " + number2);
                //currentNumberToAddString.
                long value = Long.parseLong(currentNumberToAddString.toString());
                totalJoltagePower += value; //Integer.parseInt((currentNumberToAddString.toString()));
                System.out.println(". Current total = " + totalJoltagePower);

            }

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

    }

}
