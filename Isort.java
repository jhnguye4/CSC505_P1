import java.util.*;
import java.io.*;

public class Isort {
    private ListNode head = null;
    private long numberComparisons = 0;

    public Isort() {
        // Reads in values from System.in
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            add(input.nextInt());
        }

        long start = System.nanoTime();
        sort();
        long end = System.nanoTime();
        long sortTimeInNano = end - start;
        double sortTimeIn10thSeconds = (double) sortTimeInNano / Math.pow(10, 8);
        System.err.println("Time after sorting list in 10th of second: " + sortTimeIn10thSeconds);
        System.err.println("Number of Comparisons: " + numberComparisons);
        // Printing out values of list to System.out
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        new Isort();
    }

    /*
     * The idea of insertion sort is that it will go through each element in the
     * list. At each element, it will then look at each element backwards to see if
     * it is less. It will keep moving back for each element it is less than and
     * then be inserted at the final position where it will shift all the other
     * elements down. This algorithm is normally time consuming if you are using an
     * array and need to shift each element down the array to insert, for this
     * situation we used a linkedlist so all we had to do was unlink the pointers
     */

    public void sort() {
        ListNode start = head;
        ListNode position1;
        ListNode position2;

        // Going through each element of the array from the second element to the end
        while (start.next != null) {
            start = start.next;
            position1 = start;
            position2 = position1.previous;
            // Checks if previous is null and keeps swapping elements backwards till there
            // is an element that is bigger than the original element
            while (position2 != null && (position1.data < position2.data)) {
                swap(position1, position2);
                numberComparisons++;
                position1 = position2;
                position2 = position1.previous;
            }
        }
    }

    // Adds a number to the front of the list
    public void add(int num) {
        ListNode newNode = new ListNode(num);
        if (head == null) {
            head = newNode;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Function that would swap the values of two nodes
    public void swap(ListNode position1, ListNode position2) {
        int temp = position1.data;
        position1.data = position2.data;
        position2.data = temp;
    }

    // Helper function that would print out the list
    public void printList() {
        ListNode currentNode = head;

        while (currentNode != null) {
            // Print the data at current node
            System.out.print(currentNode.data + " ");
            // Go to next node
            currentNode = currentNode.next;
        }
        System.out.println();

    }

    private class ListNode {
        /** public field that holds the data of the linked list */
        public int data;
        public ListNode next;
        public ListNode previous;

        /**
         * Constructor method that takes in one parameter that creates a node with
         * information but the previous and next links are null
         * 
         * 
         */
        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
}