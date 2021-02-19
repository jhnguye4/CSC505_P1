import java.util.*;
import java.io.*;

public class Qsort {
    private ListNode head = null;
    private long numberComparisons = 0;

    public Qsort() {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
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
        if (start == null || start.next == null || start.next == end) {
            return;
        }

        ListNode pivot = start;

        ListNode i = start;
        ListNode j = i.next;
        while (j != end) {
            if (j.data < pivot.data) {
                i = i.next;
                swap(i, j);
            }
            numberComparisons++;
            j = j.next;
        }

        // After while loop, the algorithm wants to move the pivot, which is at the
        // front,
        // to the last element that the j pointer is pointing to. By swapping the pivot
        // with this pointer, the pivot will be at the position where all elements
        // smaller than it will be to the left and all elements larger will be to the
        // right.
        swap(i, pivot);

        partition(start, i.next);
        partition(i.next, end);

    }

    // Function that is recursively called inorder to break the list into smaller
    // portions so that it can be sorted.
    public ListNode sort(ListNode lo, ListNode hi) {
        partition(lo, hi);
        return head;
    }

    public void add(int num) {
        ListNode newNode = new ListNode(num);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void swap(ListNode position1, ListNode position2) {
        int temp = position1.data;
        position1.data = position2.data;
        position2.data = temp;
    }

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