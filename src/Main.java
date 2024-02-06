import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //*****************
        // Closest
        //*****************
        //Closest0.testClosest();

        //**********************
        //TESTS
        //**********************
        /*boolean b =true;
        boolean c= b? !b : b;
        System.out.println(c);

        boolean b2 =false;
        boolean c2= b2? !b2 : b2;
        System.out.println(c2);*/


        //*************************
        // Robot
        //*************************
        //dev un appel à Player.solve();


        //*************************
        // Puzzle
        //*************************
        String[] grid = {
                "XXXXXXXXXXXXXXX",
                "X..1222333.4...",
                "X...........555",
                "X....66666.....",
                "X7..888.99999..",
                "XXXXXXXXXXXXXXX"
        };
        int height = grid.length;
        int nbBlocks = 9;
        int width =  0; //va s incrémenter
        System.out.println("--------------------");
        System.out.println("la grille de départ:");
        for(String row : grid) {
            System.out.println(row);
            for (char cell : row.toCharArray()) {
                width++;
            }
        }
        System.out.println("width: "+width/height+" / height: "+height + "/ nbBlocks :"+ nbBlocks);
        System.out.println("--------------------");

        while(hasNumbers(grid)) {
            int puzzleOut = puzzleToRight.solve(width, height, nbBlocks, grid);
            if(puzzleOut != -1) {
                grid = updateGrid(grid,puzzleOut);
            }
        }
        System.out.println("Le puzzle est vide.");
        System.out.println("Grille finale :");
        for (String row : grid) {
            System.out.println(row);
        }
    }
    public static boolean hasNumbers(String[] grid) {
        for (String row : grid) {
            for (char cell : row.toCharArray()) {
                if (Character.isDigit(cell)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String[] updateGrid(String[] grid, int blockToRemove) {
        // Créer une nouvelle grille avec le bloc retiré
        String[] newGrid = new String[grid.length];
        for (int i = 0; i < grid.length; i++) {
            newGrid[i] = grid[i].replace(Character.forDigit(blockToRemove, 10), '.');
        }
        return newGrid;
    }
}