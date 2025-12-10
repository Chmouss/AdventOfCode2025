import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2part2 {

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
                for (long i = num1; i <= num2; i++) {
                    // implementer un algo similaire a sliding window

                    //easier to manage with char array
                    String currentNumber = String.valueOf(i);
                    char[] currentNumberCharArray = currentNumber.toCharArray();

                    //current window
                    StringBuilder slidingWindow = new StringBuilder();
                    System.out.println("current number = " + currentNumber);

                    //TODO => iterate on every character and compare with the window
                    //step 2 will be increasing window size and moving etc
                    //j += slidingWindow.length() => to jump the size of the window, unsure of + 1
                    for (long j = 0; j < currentNumberCharArray.length; j += slidingWindow.length()){
                        //System.out.println(currentNumberCharArray[Math.toIntExact(j)]);
                        for (int k = 0; k < currentNumberCharArray.length; k++) { //we can change curr.length
                            //comparer K avec le pattern recherché, si match et arrive a la fin => FAKE ID (add to fakeIdsValues)

                            //coming back to this later, bit confused rn :D
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
