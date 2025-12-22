import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day9Part1V2 {

    void main(){

        try {
            File file = new File("./src/inputsDay9.txt");
            Scanner fileReader = new Scanner(file);

            //HashMap<Integer, Integer> mapCoordinatesRedTiles = new HashMap<>();
            //HashSet<String> setCoordinatesRedTiles = new HashSet<>();
            int highestLineIndex = 0;
            int highestColumnIndex = 0;

            //iterates on all the input lines and put them in the map, gets the bigger column and line for later when we have to create the matrice
            while(fileReader.hasNextLine()){
                String currentLine = fileReader.nextLine(); //scan next line
                String[] currentLineSplit = currentLine.split(","); //split in two, first number == line, second == column
                System.out.println(currentLineSplit[0] + " " + currentLineSplit[1]);
                int lineIndex = Integer.parseInt(currentLineSplit[0]);
                int columnIndex = Integer.parseInt(currentLineSplit[1]);


            }




        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

    }

}
