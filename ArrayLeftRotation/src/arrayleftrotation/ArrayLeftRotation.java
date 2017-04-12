package arrayleftrotation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayLeftRotation {
    
    public static void main(String[] args) {
        System.out.println("Enter the size of the array you wish to rotate and hit enter");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Enter how many times you want to shift the array left and hit enter");
        int k = in.nextInt();
        System.out.println("Enter each integer in the array, seperated by spaces and hit enter");
        int a[] = new int[n];
        int b[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println("Rotated array " + k + " times:");
        for(int i = k;i<n;i++){
           System.out.print(a[i] + " ");
        }
        for(int j = 0;j<k;j++){
           System.out.print(a[j] + " ");
        }
      System.out.println();
    }
}
