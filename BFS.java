package bfs;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/* This class implements a breadth first search to find the largest regions of 1's in a matrix.
 * problem encountered on hackerrank.com. Input is passed in in format width/height then the matrix itself e.g
 * 3
 * 3
 * 0 1 0
 * 0 1 1
 * 0 0 0
 * Largest region of 1's is three, as it checks all adjacent nodes including diagonal
*/
public class BFS {

    private static int runDFS(int[][] grid, int i, int j) {
        int size = 0; // size of region initalised to 0.

        /*
         * Changes cell to a 0 instead of one as will not ever need to be checked twice. Impossible to 
         * be in two seperate regions 
        */
        grid[i][j] = 0; 
        
        size++; // Add to size as this cell is connected. Size is returned each time 

        // Limiting search to the current cell's 3x3 window, checks through them all to see if a 1 is present
        for (int row = i - 1; row <= i + 1; row++) {
            for (int column = j - 1; column <= j + 1; column++) {
                // Check if each neighbour fits within boundaries of grid and is a filled cell. If true, call this method for that cell.
                if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length && grid[row][column] == 1) {
                    size += runDFS(grid, row, column); // As iterations finish, it returns size each time, hence growing.
                }
            }
        }
        return size;
    }
    
    // The method to call the search and return an int for the largest connected region. Takes grid as passed in matrix
    private static int getBiggestRegion(int[][] grid) {
        int largest = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) { // Go to each filled cell and find max connected cells
                    int sum = runDFS(grid, i, j);
                    largest = Math.max(largest, sum);
                }
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
                // System.out.print(grid[grid_i][grid_j]);
            }
            // System.out.println();
        }

        int largest = getBiggestRegion(grid);
        System.out.println(largest);
    }
}
