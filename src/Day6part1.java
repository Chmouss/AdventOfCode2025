import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day6part1 {

    void main() {

        try {
            File file = new File("./src/inputsDay6.txt");
            Scanner fileReader = new Scanner(file);

            //put a file reader on every line
            String line1 = fileReader.nextLine();
            String line2 = fileReader.nextLine();
            String line3 = fileReader.nextLine();
            String line4 = fileReader.nextLine();
            String line5 = fileReader.nextLine();

            //split the lines to only get the numbers (can be N amount of blank spaces so we remove them with the regex)
            String[] lines1split = line1.split("\\D+"); // =>  \\D+ can work aswell but not for line 5
            String[] lines2split = line2.split("\\s+");
            String[] lines3split = line3.split("\\s+");
            String[] lines4split = line4.split("\\s+");
            String[] lines5split = line5.split("\\s+");


            long totalValue = 0; //sum totalValue for the problem
            int count = 0; // count to have a track of i during the iteration on the arrays as we dont know how many arrays we have.

            //split each line in numbers or "graphical characters" for the line 5 and either sum up or multiply everything and add to the result
            for (String strings: lines1split){
                long n1 = Long.parseLong(lines1split[count]);
                long n2 = Long.parseLong(lines2split[count]);
                long n3 = Long.parseLong(lines3split[count]);
                long n4 = Long.parseLong(lines4split[count]);
                char mathSign = (lines5split[count].charAt(0));

                long result = 0;
                if(mathSign == '+'){
                    result = n1 + n2 + n3 + n4;
                } else { //mathsign == '*'
                    result = n1 * n2 * n3 * n4;
                }
                totalValue += result;
                count++;
            }
            System.out.println(totalValue);

        } catch (
                FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }
    }

}
