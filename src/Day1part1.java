//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    int currentPosition = 50; //default position of the dial is 50, we use current to change it easily
    int maxPosition = 100; //max pos is 99 and then goes back to 0 if we increment.
    int occurencesOfZero = 0;

    System.out.println("starting here, default pos : " + currentPosition);

    //read the txt file
    try{
        File file = new File("./src/inputs.txt");
        Scanner fileReader = new Scanner(file);
        while (fileReader.hasNextLine()){
            String data = fileReader.nextLine(); //scan next line
            char[] currentLine = data.toCharArray(); //recup content line en char array
            int sizeOfCurrentLine = currentLine.length; //recup taille pour operations

            StringBuilder currentNumberToAddString = new StringBuilder();

            //on recup le contenu apres la lettre R ou L (nombre qu'on va devoir additionner ou soustraire)
            for (int i = 1; i < sizeOfCurrentLine; i++) { //on recupère le contenu après la lettre de base
                currentNumberToAddString.append(currentLine[i]);
            }

            int currentNumberToAdd = Integer.parseInt(String.valueOf(currentNumberToAddString));

            //regarder si R ou L, prendre le nombre et faire l'opération ensuite
            if(currentLine[0] == 'R'){ //R, increment
                currentPosition = (currentPosition + currentNumberToAdd) % maxPosition;
            } else { //L, decrement
                currentPosition = (currentPosition - currentNumberToAdd) % maxPosition;
            }

            if(currentPosition == 0)
                occurencesOfZero++;
            System.out.println(currentPosition);

        }
    } catch (FileNotFoundException e){
        System.out.println("error while reading the file");
        e.printStackTrace();
    }
    System.out.println("occurences of Zero : " + occurencesOfZero);



}
