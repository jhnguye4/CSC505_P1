import java.util.*;
import java.io.*;

public class Msort {
    private ListNode head = null;
    private long numberComparisons = 0;

    public Msort() {
        // Reads in values from System.in
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            add(input.nextInt());
        }

        long start = System.nanoTime();
        head = sort(head);
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
        new Msort();
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tmpList = dummy;
        // Loop is used to point tmpList to the smallest element between the two lists
        // until one of the lists have reached its end
        while (list1 != null && list2 != null) {
            // Value in list1 is smaller than value of list two. tmpList points to value in
            // list1 and pointer in list1 is moved forward
            if (list1.data < list2.data) {
                tmpList.next = list1;
                list1 = list1.next;
            } else {
                // Value in list2 is smaller than value of list one. tmpList points to value in
                // list1 and pointer in list1 is moved forward
                tmpList.next = list2;
                list2 = list2.next;
            }
            // moves the pointer of tmpList forward
            tmpList = tmpList.next;
            numberComparisons++;
        }
        // For odd number of nodes in list1 and list2, if list1 or list2 have not
        // reached end then it will enter if statement to point to last element.
        if (list1 != null) {
            tmpList.next = list1;
            numberComparisons++;
        }
        if (list2 != null) {
            tmpList.next = list2;
            numberComparisons++;
        }
        return dummy.next;

    }

    // Main function that will be called recursively to half our lists till lists
    // are one element. After halving, it will merge elements back together in
    // sorted order.
    public ListNode sort(ListNode head) {
        // Checks if the node is null or there is no elements next to the single element
        // in the list
        if (head == null || head.next == null) {
            return head;
        }

        // Gets the middle element of the list
        ListNode mid = middle(head);
        ListNode middleHead = mid.next;
        // Sets node next to middle null so that when it recursively calls it will break
        // list into halves till there is one element
        mid.next = null;
        ListNode list1 = sort(head);
        ListNode list2 = sort(middleHead);

        return merge(list1, list2);
    }

    // Function that will find the middle node of list by having two pointers. With
    // slow pointer moving one node forward for every two nodes that the fast
    // pointer moves forward. The node that the slow node falls on is the middle
    // node of the list.
    private ListNode middle(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    // Helper function that would print out the list
    public void printList(ListNode begin) {
        ListNode currentNode = begin;

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