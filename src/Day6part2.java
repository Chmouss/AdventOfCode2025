import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6part2 {

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

            //split every line in char arrays
            char[] lines1split = line1.toCharArray();
            char[] lines2split = line2.toCharArray();
            char[] lines3split = line3.toCharArray();
            char[] lines4split = line4.toCharArray();
            char[] lines5split = line5.toCharArray();

            long totalValue = 0; //sum totalValue for the problem

            String n1 = "", n2 = "", n3 = "", n4 = "";
            int count = 0;
            char mathSign = 'a';

            for (int i = 0; i < lines1split.length; i++) {
                //if the whole vertical line is blank, we reset all the strings and the count
                if((lines1split[i] == ' ' && lines2split[i] == ' ' && lines3split[i] == ' ' && lines4split[i] == ' ' && lines5split[i] == ' ') ||
                    (i == lines1split.length -1)){

                    long n1ToAdd = 0, n2ToAdd = 0, n3ToAdd = 0, n4ToAdd = 0;
                    if (!n1.isEmpty()) n1ToAdd = Long.parseLong(n1);
                    if (!n2.isEmpty()) n2ToAdd = Long.parseLong(n2);
                    if (!n3.isEmpty()) n3ToAdd = Long.parseLong(n3);
                    if (!n4.isEmpty()) n4ToAdd = Long.parseLong(n4);

                    long result = 0;
                    if(mathSign == '+'){
                        if(n1ToAdd > 0) result += n1ToAdd;
                        if(n2ToAdd > 0) result += n2ToAdd;
                        if(n3ToAdd > 0) result += n3ToAdd;
                        if(n4ToAdd > 0) result += n4ToAdd;

                    } else { //mathsign == '*'
                        result = 1; // avoid multiplying by zero
                        if (n1ToAdd > 0) result *= n1ToAdd;
                        if (n2ToAdd > 0) result *= n2ToAdd;
                        if (n3ToAdd > 0) result *= n3ToAdd;
                        if (n4ToAdd > 0) result *= n4ToAdd;
                    }
                    totalValue += result;

                    //reset count and numbers after we did the calculations
                    n1 = ""; n2 = ""; n3 = ""; n4 = "";
                    count = 0;
                } else {

                    if(lines5split[i] == '+' || lines5split[i] == '*')
                        mathSign = lines5split[i];

                    switch (count){
                        case 0:
                            if(Character.getNumericValue(lines1split[i]) != -1)
                                n4 += Character.getNumericValue(lines1split[i]);
                            if(Character.getNumericValue(lines2split[i]) != -1)
                                n4 += Character.getNumericValue(lines2split[i]);
                            if(Character.getNumericValue(lines3split[i]) != -1)
                                n4 += Character.getNumericValue(lines3split[i]);
                            if(Character.getNumericValue(lines4split[i]) != -1)
                                n4 += Character.getNumericValue(lines4split[i]);

                            //n4 += "" + n1ToAdd + n2ToAdd + n3ToAdd + n4ToAdd;
                            System.out.println(n4);
                            break;
                        case 1:
                            if(Character.getNumericValue(lines1split[i]) != -1)
                                n3 += Character.getNumericValue(lines1split[i]);
                            if(Character.getNumericValue(lines2split[i]) != -1)
                                n3 += Character.getNumericValue(lines2split[i]);
                            if(Character.getNumericValue(lines3split[i]) != -1)
                                n3 += Character.getNumericValue(lines3split[i]);
                            if(Character.getNumericValue(lines4split[i]) != -1)
                                n3 += Character.getNumericValue(lines4split[i]);
                            //n3 += "" + n1ToAdd + n2ToAdd + n3ToAdd + n4ToAdd;
                            System.out.println(n3);
                            break;
                        case 2:
                            if(Character.getNumericValue(lines1split[i]) != -1)
                                n2 += Character.getNumericValue(lines1split[i]);
                            if(Character.getNumericValue(lines2split[i]) != -1)
                                n2 += Character.getNumericValue(lines2split[i]);
                            if(Character.getNumericValue(lines3split[i]) != -1)
                                n2 += Character.getNumericValue(lines3split[i]);
                            if(Character.getNumericValue(lines4split[i]) != -1)
                                n2 += Character.getNumericValue(lines4split[i]);
                            //n2 += "" + n1ToAdd + n2ToAdd + n3ToAdd + n4ToAdd;
                            System.out.println(n2);
                            break;
                        case 3:
                            if(Character.getNumericValue(lines1split[i]) != -1)
                                n1 += Character.getNumericValue(lines1split[i]);
                            if(Character.getNumericValue(lines2split[i]) != -1)
                                n1 += Character.getNumericValue(lines2split[i]);
                            if(Character.getNumericValue(lines3split[i]) != -1)
                                n1 += Character.getNumericValue(lines3split[i]);
                            if(Character.getNumericValue(lines4split[i]) != -1)
                                n1 += Character.getNumericValue(lines4split[i]);
                            //n1 += "" + n1ToAdd + n2ToAdd + n3ToAdd + n4ToAdd;
                            System.out.println(n1);
                            break;
                    }
                    count++;

                }
            }
            System.out.println(totalValue);

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }
    }

}
