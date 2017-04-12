
import java.util.*;


public class LinkedList
{
    Node head;  // creates the head of the list
  
    // Definition of the node class, contains its data and a pointer to the next node. Data is type int for demo purposes 
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
  
    // Adds a new Node to the front of the list. 
    public void addNewNode(int data)
    {
        // Creates a new node with data passed in 
        Node n = new Node(data);
        // Sets the current head as the new nodes next node.
        n.next = head;
        // Sets the head as this node
        head = n;
    }
    
    /* Method to detect a cycle and return 1 if true, 0 if false
     * Works by having two nodes start at head, and iterate through at different speeds.
     * If no cycle, they will never be equal as fast one reaches end
     * If there's a cycle, they will eventually be the same value. 
    */
    int detectCycle()
    {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {  // Loop will exit when fast or fast.next equals null (unlikely slow will ever do but possible)
            slow = slow.next;           // Moves along node by node (1,2,3,4,5)
            fast = fast.next.next;      // Moves along skipping every other node (1,3,5)
            if (slow == fast) {
                System.out.println("Loop found via Floyd's cycle-finding algorithm");
                return 1;
            }
        }
        return 0; // Loop has exited, hence no loop 
    }
    
    /* Similarly a method to return true or false if a cycle is detected.
     * This is slower than the previous test. It works by creating an arraylist
     * that add's each node into it when it traverses through them. 
     * When moving onto each node it checks the array to see if the node already exists
    * If it does, cycel is detected as no node should have same data AND same next pointer.
    */
    boolean hasCycle(Node head) {
    if(head == null) return false;
    ArrayList<Node> visited = new ArrayList<>();
    visited.add(head);
    while(head.next != null) {
        head = head.next;
        for(Node n: visited) {
            if(n == head){
                System.out.println("Loop found via visited method");
                return true;
            }
        }
        visited.add(head);
        }
    return false;
    }
 
    // Main function which will run and test a dummy list to see if cycle.
    public static void main(String args[])
    {
        LinkedList loopedList = new LinkedList();
 
        loopedList.addNewNode(1);
        loopedList.addNewNode(2);
        loopedList.addNewNode(3);
        loopedList.addNewNode(4);
        loopedList.addNewNode(5);
        loopedList.addNewNode(6);
        
        // Crudely makes the last node in the list's next pointer point to the head. 
        loopedList.head.next.next.next.next.next = loopedList.head;  
 
        // Call our function to test for a cycle
        loopedList.detectCycle();
        loopedList.hasCycle(loopedList.head);
    }
} 
