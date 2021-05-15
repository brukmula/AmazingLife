/*
Amazing Life
Bruk Mulatu
COSC 2203
Assignment 1: Amazing Life
Due Date: August 31, 2020
Approved by: Robel Tadele
 */
import java.util.Scanner;

public class AmazingLife {
    public static void main(String [] args) {

        String display;
        String firstRow;
        int genNum;
        int rows;
        int columns;

        int[][] currentGen;
        int[][] firstGen;

        Scanner input = new Scanner(System.in);
        // Ask user how they would like the generations displayed.

        display = input.nextLine();

        genNum = input.nextInt();

        //Number of Rows
        columns = input.nextInt();
        //Enter the number of columns
        rows = input.nextInt();


        //Array that creates a table with the number of rows and columns.
        firstGen = new int[rows + 2][columns + 2];

        //Nested for loop to enter the first generation
        for (int x = 1; x <= rows; x++) {
            //Input a line for the first generation for each row
            firstRow = input.next();
            for (int i = 1; i <= columns; i++) {
                //For the amount of columns you input a value
                if (firstRow.charAt(i - 1) == '1') {
                    firstGen[x][i] = 1;
                } else {
                    firstGen[x][i] = 0;
                }
            }
        }
        System.out.println("First Generation: "); //Print out first generation
        GridClass.printGeneration(firstGen, rows, columns, genNum);

        currentGen = firstGen.clone();


        if (display.equals("v")) {

            for (int i = 1; i < genNum; i++) {
                System.out.println("Generation " + (i + 1) + ":");
                currentGen = GridClass.getNextGen(rows, columns, currentGen, genNum);
                // Replace first Gen with current gen in a for loop
                GridClass.printGeneration(currentGen, rows, columns, genNum);
            }
        } else if (display.equals("s")){

            for (int i = 1; i < genNum; i++) {
                currentGen = GridClass.getNextGen(rows, columns, currentGen, genNum);

                if (i == genNum-1)
                System.out.println("Last Generation: ");
                // Replace first Gen with current gen in a for loop
                GridClass.printGeneration(currentGen, rows, columns, genNum);
            }
        }
    }

}
