package bubblesort;

import java.util.*;

public class BubbleSort {

    // An int to store how many times the bubbleSort swaps two numbers
    private static int swaps = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the size of the array to be sorted");
        int size = scan.nextInt();
        int[] array = new int[size];
        System.out.println("Please enter numbers of the array seperated by spaces");
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();

        bubbleSort(array);

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + array[0]);
        System.out.println("Last Element: " + array[array.length - 1]);
        System.out.print("Array is now: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /* Method that perform the bubble sort on array that was read in in main */
    private static void bubbleSort(int[] array) {
        if (array == null) {
            return;
        }

        boolean swapped = true;
        int endOffset = 0; // optimizes code
        /* Only executes while loop when swapped bool is set to true.
         * Soon as loop starts, it defaults to false. 
         * If conditions are met, set back to true when swap takes place
         */
        while (swapped) {
            swapped = false;
            for (int i = 1; i < array.length - endOffset; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    swapped = true;
                }
            }
            endOffset++;
        }
    }

    /* Swap method which takes the two integers to be swapped ( i & j )  
     * Places i into temporary int, changes value of i to j, and set j to temp value
     * Also increments the swap counter
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        swaps++;
    }
}
