import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5part1 {

    void main() {

        //read the txt file
        try {
            File file = new File("./src/inputsDay5.txt");
            Scanner fileReader = new Scanner(file);

            //map => Key = start of the range, Value = end of the range
            HashMap<Long, Long> mapRangeStartToEnd = new HashMap<>();
            boolean hasReachedIDsToCheck = false;
            int totalOfFreshIngredients = 0;

            while (fileReader.hasNextLine()) {
                String currentLine = fileReader.nextLine(); //scan next line
                int currentLineSize = currentLine.length();

                //we reached the second part of the file // can be moved in the first if
                if(currentLineSize == 0) {
                    hasReachedIDsToCheck = true;
                    currentLine = fileReader.nextLine();
                }

                if(!hasReachedIDsToCheck){
                    //split the line in 2 until we reach the second part of the txt file
                    String[] ranges = currentLine.split("-");

                    //first for to check the ids of the valid ingredients and add them to the set
                    long rangeStart = Long.parseLong(ranges[0]);
                    long rangeEnd = Long.parseLong(ranges[1]);
                    if(mapRangeStartToEnd.containsKey(rangeStart)){
                        //we only change the value of the existing entry if the new range is bigger than the existing one.
                        if(mapRangeStartToEnd.get(rangeStart) < rangeEnd)
                            mapRangeStartToEnd.put(rangeStart, rangeEnd);
                    } else {
                        mapRangeStartToEnd.put(rangeStart, rangeEnd);
                    }

                } else { //second part to check the map if it contains the value between its range
                    for (Map.Entry<Long, Long> entry: mapRangeStartToEnd.entrySet()){
                        long currentNumber = Long.parseLong(currentLine);
                        if(currentNumber >= entry.getKey() && currentNumber <= entry.getValue()){
                            totalOfFreshIngredients++;
                            break;
                        }
                    }
                }
            }
            System.out.println("total fresh ingredients = " + totalOfFreshIngredients);

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

    }

}
