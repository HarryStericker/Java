import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SortStringArray{
    
    public static void main(String[] args) {
        /* 
        * Block of code to read in an array of strings, assuming all are in int format
        * Stored in an array simply called array  
        */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] array = new String[n];
        for(int i = 0; i < n; i++){array[i] = in.next();}
        
        /* 
        * Using Arrays.sort (Object [], Comparator) to sort the array.
        * Overrode the comparator method for type string, which returns another method
        */
        Arrays.sort(array,new Comparator<String>() {
            @Override
            public int compare(String a, String b) 
            {
                return compareStringAsInteger(a,b);
            }
        });
        
        // Simple string builder to avoid multiple slow system io calls
        StringBuilder output = new StringBuilder("");
        for(String num : array){output.append(num+"\n");}
        System.out.println(output);
    } // End of main class
    
    /*
    * Simple but efficient way to compare string integers
    * If one int has more chars, it therefore must be larger (123 vs 1234). hence return 1 or -1.
    * Otherwise if they are same length, check the leading chars until one is bigger than the other
    */
    static int compareStringAsInteger(String s1, String s2)
    {
        if(s1.length() > s2.length()) return 1;
        if(s1.length() < s2.length()) return -1;
        for(int i = 0; i < s1.length(); i++)
        {
            if((int)s1.charAt(i) > (int)s2.charAt(i)) return 1;
            if((int)s1.charAt(i) < (int)s2.charAt(i)) return -1;
        }
        return 0;
    }
}