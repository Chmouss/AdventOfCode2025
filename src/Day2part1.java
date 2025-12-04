import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class Day2part1 {

    void main() {

        long sumOfFakeIdsValues = 0;

        //read the txt file
        try {
            File file = new File("./src/inputsDay2.txt");
            Scanner fileReader = new Scanner(file);
            String line = fileReader.nextLine();

            //split all of the input file by pairs (as its one long line)
            String[] pairs = line.split(",");
            //System.out.println(pairs[0]);

            //split all of the input by pairs and check if they are an even number, we check if they have a repeated pattern
            for(String numbers: pairs){
                String[] nums = numbers.split("-");
                //System.out.println(nums[0]);
                //System.out.println(nums[1]);

                long num1 = Long.parseLong(nums[0]);
                long num2 = Long.parseLong(nums[1]);
//                System.out.println(num1);
//                System.out.println(num2);

                // range of numbers from nums1 to num2
                for (long i = num1; i < num2; i++) {
                    if((String.valueOf(i).length() % 2) == 0){ //check => if the size is odd !
                        //split a la moitié et comparer les deux, si egal on ajoute a la somme des fake IDs
                        String numberToSplit = String.valueOf(i);
                        int midOfNumberToSplit = numberToSplit.length() / 2;
                        String firstHalf = numberToSplit.substring(0, midOfNumberToSplit);
                        String secondHalf = numberToSplit.substring(midOfNumberToSplit);

                        if(firstHalf.equals(secondHalf)){
                            sumOfFakeIdsValues += Long.parseLong(numberToSplit);
                            System.out.println("fake id found: " + numberToSplit);
                        }

                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

        System.out.println("total of fake id values: " + sumOfFakeIdsValues);


    }
}
