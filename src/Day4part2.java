import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4part2 {

    void main() {

        //read the txt file
        try {
            File file = new File("./src/inputsDay4.txt");
            Scanner fileReader = new Scanner(file);

            //init matrice
            int nbLignes = 139;
            int nbColonnes = 139;
            char[][] matrice = new char[nbLignes][nbColonnes];

            int lineIndex = 0;
            int totalPapersThatCanBeRemoved = 0;

            int tailleMaxToCheck = 138;

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine(); //scan next line
                char[] currentLine = data.toCharArray(); //recup content line en char array
                int currentLineSize = currentLine.length; //recup taille pour operations

                //remplissage de la ligne actuelle de la matrice
                for (int colIndex = 0; colIndex < currentLineSize; colIndex++) { // i == col index
                    matrice[lineIndex][colIndex] = currentLine[colIndex];
                }
                lineIndex++;
            }

            //logique pour le probleme => check le nombre de papiers qui sont en easy access
            //cad qui ont MOINS DE 4 papiers autour d'eux (8 positions autour de la position actuelle dans la matrice)
            // on parcourt toute la matrice, quand on trouve un '@', ou check les 8 caracteres autour, si total inferieur a 4 => easyaccess

            //ajout variable pour savoir si on peut encore enlever du papier, reset variable a chaque iteration
            //si on trouve du papier, on remet a true
            boolean canStillRemovePapers = true;
            while(canStillRemovePapers) {
                canStillRemovePapers = false;
                for (int i = 0; i < nbLignes; i++) {
                    for (int j = 0; j < nbColonnes; j++) {
                        if (matrice[i][j] == '@') {
                            int countPapersAround = 0; //8papers in directions
                            if (i > 0 && j > 0 && matrice[i - 1][j - 1] == '@') countPapersAround++; // haut-gauche
                            if (i > 0 && matrice[i - 1][j] == '@') countPapersAround++; // haut
                            if (i > 0 && j < nbColonnes - 1 && matrice[i - 1][j + 1] == '@') countPapersAround++; // haut-droite
                            if (j > 0 && matrice[i][j - 1] == '@') countPapersAround++; // gauche
                            if (j < nbColonnes - 1 && matrice[i][j + 1] == '@') countPapersAround++; // droite
                            if (i < nbLignes - 1 && j > 0 && matrice[i + 1][j - 1] == '@') countPapersAround++; // bas-gauche
                            if (i < nbLignes - 1 && matrice[i + 1][j] == '@') countPapersAround++; // bas
                            if (i < nbLignes - 1 && j < nbColonnes - 1 && matrice[i + 1][j + 1] == '@') countPapersAround++; // bas-droite

                            if (countPapersAround < 4) {
                                matrice[i][j] = '.';
                                totalPapersThatCanBeRemoved++;
                                canStillRemovePapers = true;
                            }

                        }
                    }
                }
            }

            //print matrice
            for (int i = 0; i < nbLignes; i++) {
                for (int j = 0; j < nbColonnes; j++) {
                    System.out.print(matrice[i][j]);
                }
                System.out.println();
            }

            System.out.println(totalPapersThatCanBeRemoved);

        } catch (FileNotFoundException e) {
            System.out.println("error while reading the file");
            e.printStackTrace();
        }

    }

}
