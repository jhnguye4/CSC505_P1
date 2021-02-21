import java.util.*;
import java.io.*;

public class Qsort {
    private ListNode head = null;
    private long numberComparisons = 0;

    public Qsort() {
        // Reads in values from System.in
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            add(input.nextInt());
        }
        ListNode endPosition = head;
        while (endPosition != null) {
            endPosition = endPosition.next;
        }
        long start = System.nanoTime();
        sort(head, endPosition);
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
        new Qsort();
    }

    // Function that does most of the heavy lifting for this sorting algorithm. The
    // idea of partition is that it will randomly select a pivot and move all
    // elements that are smaller than the pivot to the left and elements greater
    // than the pivot to the right.
    public void partition(ListNode start, ListNode end) {
        // if start is null, one element or next to last element it will backtrack
        if (start == null || start.next == null || start.next == end) {
            return;
        }
        // Making pivot the first element
        ListNode pivot = start;

        // Two pointers pointing to first and second elements.
        ListNode i = start;
        ListNode j = i.next;
        // iterating from the second element of list to the end
        while (j != end) {
            // if element at j is less than pivot then the first pointer is moved forward
            // and elements are swapped at pointer i and j.
            if (j.data < pivot.data) {
                i = i.next;
                swap(i, j);
            }
            numberComparisons++;
            // pointer j is moved forward
            j = j.next;
        }

        // After while loop, the algorithm wants to move the pivot, which is at the
        // front, to the last element that the i pointer is pointing to. By swapping the
        // pivot with this pointer, the pivot will be at the position where all elements
        // smaller than it will be to the left and all elements larger will be to the
        // right.
        swap(i, pivot);

        // recursively call from start of list to value next to pivot
        partition(start, i.next);
        // recursively call from node next to pivot to the end.
        partition(i.next, end);

    }

    // Function that calls partition to do the sorting
    public ListNode sort(ListNode lo, ListNode hi) {
        partition(lo, hi);
        return head;
    }

    // Adds a number to the front of the list
    public void add(int num) {
        ListNode newNode = new ListNode(num);
        if (head == null) {
            head = newNode;
        } else {
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

        /**
         * Constructor method that takes in one parameter that creates a node with
         * information but the previous and next links are null
         * 
         * 
         */
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

}