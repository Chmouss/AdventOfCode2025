import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2part1 {

    void main() {
        //read the txt file
        try {
            File file = new File("./src/inputsDay2.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {


            }
        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

        System.out.println("");


    }
}
