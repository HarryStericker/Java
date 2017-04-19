
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/* A class to calculate the running median of integers input.
 * Done by having two heaps, one for the lower half one for the upper half on numbers input
 * To find the median, it looks at the root of each heap. If heap sizes are equal, median is root(a) + root(b)/2
 * If heap sizes !equal, due to how elements are added median is root of upper numbers heap.
 */
public class Heaps {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Comparator.reverseOrder()); // A heap of the smallest half of numbers, biggest on top
        PriorityQueue<Integer> uppers = new PriorityQueue<Integer>(); // A heap of the biggest half of numbers, smallest on top

        int n = sc.nextInt();  // reads in the size of numbers about to passed in via console
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();  // reads in the numbers one by one (for running median)

            if (!lowers.isEmpty() && m <= lowers.peek()) { // check heap isnt empty, and number read in is smaller than root of this heap (root == max)
                lowers.add(m); // adds it to lowers
            } else {
                uppers.add(m); // otherwise put into uppers. Offer could be used but it wouldnt error if not inserted. Should implement exception handling
            }

            while (lowers.size() > uppers.size()) { // Balancing the heaps to keep them similar size - takes top off lowers, insert to uppers
                uppers.add(lowers.poll());
            }
            while (uppers.size() - lowers.size() > 1) { // Dpes the opossite - if there's a diff of more than 1 take lowest from uppers & add to lowers
                lowers.add(uppers.poll());
            }

            double median; // division is used later, ensures result not truncated
            if (lowers.size() == uppers.size()) {
                median = (lowers.peek() + uppers.peek()) / 2.0;
            } else {
                median = uppers.peek();
            }
            System.out.printf("%.1f\n", median); //Prints a running median as numbers are added in. Formatted to one decimal place. 
        }

        sc.close();
    }
}
