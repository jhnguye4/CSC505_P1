import java.util.*;
import java.io.*;

public class Msort {
    private ListNode head = null;
    private long numberComparisons = 0;

    public Msort() {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            add(input.nextInt());
        }


        long start = System.nanoTime();
        head = sort(head);
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
        new Msort();
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tmpList = dummy;
        while (list1 != null && list2 != null) {

            if (list1.data < list2.data) {
                tmpList.next = list1;
                list1 = list1.next;
            } else {
                tmpList.next = list2;
                list2 = list2.next;
            }
            tmpList = tmpList.next;
            numberComparisons++;
        }
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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middle(head);
        ListNode middleHead = mid.next;
        mid.next = null;
        ListNode list1 = sort(head);
        ListNode list2 = sort(middleHead);

        return merge(list1, list2);
    }

    private ListNode middle(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

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