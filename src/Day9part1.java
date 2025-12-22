import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day9part1 {

    void main(){

        try {
            File file = new File("./src/inputsDay9.txt");
            Scanner fileReader = new Scanner(file);

            //HashMap<Integer, Integer> mapCoordinatesRedTiles = new HashMap<>();
            HashSet<String> setCoordinatesRedTiles = new HashSet<>();
            int highestLineIndex = 0;
            int highestColumnIndex = 0;

            //iterates on all the input lines and put them in the map, gets the bigger column and line for later when we have to create the matrice
            while(fileReader.hasNextLine()){
                String currentLine = fileReader.nextLine(); //scan next line
                String[] currentLineSplit = currentLine.split(","); //split in two, first number == line, second == column
                System.out.println(currentLineSplit[0] + " " + currentLineSplit[1]);
                int lineIndex = Integer.parseInt(currentLineSplit[0]);
                int columnIndex = Integer.parseInt(currentLineSplit[1]);

                //to find the highest ones we check every entry if it is bigger than the one we found so far
                if (lineIndex > highestLineIndex)
                    highestLineIndex = lineIndex;
                if(columnIndex > highestColumnIndex)
                    highestColumnIndex = columnIndex;

                //mapCoordinatesRedTiles.put(lineIndex, columnIndex);
                setCoordinatesRedTiles.add(currentLine);
            }

            //create the matrix based on the highest values we found in the coordinates
            char[][] matrix = new char[highestLineIndex][highestColumnIndex];
            for (int i = 0; i < highestLineIndex; i++){
                for (int j = 0; j < highestColumnIndex; j++) {
                    matrix[i][j] = '.';
                }
            }

            //iterate on the set and replace the coordinates from the set with '#'
            for (String coordinates: setCoordinatesRedTiles){
                //System.out.println(coordinates);
                String[] coordinatesSplit = coordinates.split(",");
                int lineIndex = Integer.parseInt(coordinatesSplit[0]);
                int columnIndex = Integer.parseInt(coordinatesSplit[1]);
                matrix[lineIndex][columnIndex] = '#';
            }


            for (int i = 0; i < highestLineIndex; i++){
                for (int j = 0; j < highestColumnIndex; j++) {
                    System.out.println(matrix[i][j]);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

    }

}
