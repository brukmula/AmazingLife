/*
Grid Class
Bruk Mulatu
COSC 2203
Assignment 1: Amazing Life
Due Date: August 31, 2020
Approved by: Robel Tadele
 */

public class GridClass {

    //Method that returns the number of neighbors a cell has.
    public static int getNeighbor(int x, int y, int[][] currentGen){

        int neighborCount = 0;

            // If statements that check the neighbours
            //Check the logic
            if (currentGen[x - 1][y] == 1) {
                neighborCount++;
            } if (currentGen[x - 1][y - 1] ==1) {
                neighborCount++;
            } if (currentGen[x][y - 1] == 1 ) {
                neighborCount++;
            } if (currentGen[x + 1][y - 1] == 1) {
                neighborCount++;
            } if (currentGen[x + 1][y] ==1 ) {
                neighborCount++;
            } if (currentGen[x + 1][y + 1] ==1 ) {
                neighborCount++;
            } if (currentGen[x][y + 1]==1 ) {
                neighborCount++;
            } if (currentGen[x - 1][y + 1] ==1 ) {
                neighborCount++;
            }
        return neighborCount;
    }
    //Method that gets the next generation
    public static int[][] getNextGen (int rows, int columns, int [][] firstGen, int genNumber) {

        int [][]  currentGen= new int[rows+2][columns+2];

            //For Loop for the number of generations
            for (int x =0; x<genNumber; x++) {

                int [] [] neighborCount = new int[rows+2][columns+2];

                //For loop for the number of rows.
                for (int i = 1; i <= rows; i++) {
                    // For loop for the number of columns.
                    for (int j = 1; j <= columns; j++) {
                        //Get the number of neighbors
                        neighborCount[i][j] = getNeighbor(i, j, firstGen);
                    }
                }
                //Nested for loop to create next generation
                    for (int i = 1; i <= rows; i++) {
                        for (int j= 1; j <= columns; j++){
                            if (firstGen[i][j] == 1) {
                                // If a cell is occupied but has no more than one occupied neighbor, then it is empty in the next generation
                                if(neighborCount[i][j] <= 1){
                                    currentGen[i][j] = 0;

                                    //If a cell is occupied and has four or more occupied neighbors,then it is empty in the next generation.
                                } else if (neighborCount[i][j] == 3 || neighborCount[i][j] == 2) {
                                    currentGen[i][j] = 1;

                                //If a cell is occupied and has four or more occupied neighbors, then it is empty in the next generation.
                                } else if (neighborCount[i][j] >= 4) {
                                    currentGen[i][j] = 0;
                                }
                            } else if (firstGen[i][j] ==0){
                                //An empty cell is occupied in the next generation if it has exactly three occupied neighbors.
                                if (neighborCount[i][j] == 3){
                                    currentGen[i][j] = 1;
                                }
                            }

                        }
                    }
                }
                return currentGen;
        }

        public static void silent(int [] [] currentGen, int rows, int columns, int genNum) {

            int[][] newGen = GridClass.getNextGen(rows, columns, currentGen, genNum);

            int i = 0;

                for (int k = 1; k < rows; k++) {
                    for (int l = 1; l < columns; l++) {

                        i ++;

                        if (currentGen[k][l] == 1) {
                            newGen[k][l] = 1;
                            System.out.print("*");
                            //Else print a dot
                        } else {
                            newGen[k][l] = 0;
                            System.out.print(".");
                        }
                    }
                    System.out.println();
                }

        }
        //Method that prints out the next generation
    public static void printGeneration(int [] [] currentGen, int rows, int columns, int genNum) {

        int[][] newGen = GridClass.getNextGen(rows, columns, currentGen, genNum);

            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= columns; j++) {

                    //If 1 print an *
                    if (currentGen[i][j] == 1){
                        newGen[i][j] = 1;
                        System.out.print("*");
                        //Else print a dot
                    } else  {
                        newGen[i][j] = 0;
                        System.out.print(".");
                    }
                }
               System.out.println();

            }
        }
    }



