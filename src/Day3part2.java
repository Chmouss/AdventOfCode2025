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

                //



            }

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

    }

}
