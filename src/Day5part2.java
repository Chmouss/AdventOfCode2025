import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day5part2 {

    void main() {

        //read the txt file
        try {
            File file = new File("./src/inputsDay5.txt");
            Scanner fileReader = new Scanner(file);

            //map => Key = start of the range, Value = end of the range
            HashMap<Long, Long> mapStartRangeToEndRange = new HashMap<>();

            long totalOfFreshIngredients = 0;

            while (fileReader.hasNextLine()) {
                String currentLine = fileReader.nextLine();
                int currentLineSize = currentLine.length();

                if (currentLineSize == 0) //stop at the blank line
                    break;

                //split the line between 2 long (in the txt file they are separated by a - )
                String[] ranges = currentLine.split("-");
                long newNumberRangeStart = Long.parseLong(ranges[0]);
                long newNumberRangeEnd = Long.parseLong(ranges[1]);

                boolean isContainedWithinOrEquals = false;
                boolean isNewEntryOutstandingTheMapEntry = false;
                boolean isOverlappingAtTheEnd = false;
                boolean isOverlappingAtTheStart = false;

                long mapEntryToDelete = 0;
                long mapEntryToAddIfOverlap = 0;



                //note to work on this later =>
                //there are a few possible cases. (I have to double check for the equals ... )
                // 1 -> both values are outstanding the current range => ex 1-10 are outstanding 3-5, we fully replace that entry
                // 2 -> both values are equals => do nothing.
                // 3 -> both values are contained within the range (START equals or greater than map entry AND end equals or smaller than map END)
                // 4 -> overlapping the start =>
                //      start of range is LESSER or equals to the current entry START and the end is STRICLTY between the entry START AND END (
                // 5 -> overlapping the end =>
                //      start of range is GREATER or equals to the current entry start and LESSER than the map range end
                //      AND the end of range is strictly between map entry and end

                //note for the equals in the overlap ->
                // equals or lesser/greater for the number that is BETWEEN both, other one is stricly greater or lesser



                //check existing entries in the map
                for (Map.Entry<Long, Long> entry: mapStartRangeToEndRange.entrySet()){
                    long mapEntryStart = entry.getKey();
                    long mapEntryEnd = entry.getValue();

                    if(newNumberRangeStart >= mapEntryStart && newNumberRangeEnd <= mapEntryEnd){
                        isContainedWithinOrEquals = true;
                        break;
                    }
                    if(newNumberRangeStart < mapEntryStart && newNumberRangeEnd > mapEntryEnd){
                        //replace that entry with the new one
                        mapEntryToDelete = mapEntryStart;
                        isNewEntryOutstandingTheMapEntry = true;
                        break;
                    } else if (newNumberRangeStart < mapEntryStart && (newNumberRangeEnd >= mapEntryStart && newNumberRangeEnd <= mapEntryEnd)) {
                        isOverlappingAtTheEnd = true;
                        mapEntryToAddIfOverlap = mapEntryStart -1;
                        break;
                    } else if (newNumberRangeEnd > mapEntryEnd && (newNumberRangeStart >= mapEntryStart && newNumberRangeStart <= mapEntryEnd)){
                        isOverlappingAtTheStart = true;
                        mapEntryToAddIfOverlap = mapEntryEnd +1;
                        break;
                    }
                }

                //if both values are outstanding the map entry, we replace that one
                if(isNewEntryOutstandingTheMapEntry){
                    mapStartRangeToEndRange.remove(mapEntryToDelete);
                    mapStartRangeToEndRange.put(newNumberRangeStart, newNumberRangeEnd);
                } else if(isOverlappingAtTheEnd){
                    mapStartRangeToEndRange.put(newNumberRangeStart, mapEntryToAddIfOverlap);
                } else if(isOverlappingAtTheStart){
                    mapStartRangeToEndRange.put(mapEntryToAddIfOverlap, newNumberRangeEnd);
                } else if (!isContainedWithinOrEquals){ //if it is all good, we simply add it to the map
                    mapStartRangeToEndRange.put(newNumberRangeStart, newNumberRangeEnd);
                }

            }

            for (Map.Entry<Long, Long> map: mapStartRangeToEndRange.entrySet()){
                long mapKey = map.getKey();
                long mapValue = map.getValue();
                totalOfFreshIngredients += (mapValue - mapKey) +1; //ex: 3-5 => 3, 4 and 5 are valid IDs
            }
            System.out.println(totalOfFreshIngredients);

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

    }

}
