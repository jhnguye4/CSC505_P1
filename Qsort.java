import java.util.*;
import java.io.*;

public class Qsort {
    private ListNode head = null;
    private int size;

    public Qsort() {
        // Asking user to input a text file that ends with input.txt and with a single
        // integer on each line
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a filename or Q to quit: ");
        String filename = console.next().toLowerCase();

        Scanner input = null;
        PrintStream output = null;
        // Will constantly ask user for input files that end with input.txt to sort
        // numbers. Will reprompt user for valid file or type q to quit
        while (!(filename.equals("q"))) {
            if (filename.endsWith("input.txt")) {
                // Scanner for input file
                input = getInputScanner(filename);
                if (input != null) {
                    // Calls function to print the sorted list into output file
                    output = getOutputPrintStream(console, filename);
                    if (output != null) {
                        // Function that goes into input file and puts each integer per line into global
                        // list
                        process(input);

                        long start = System.nanoTime();
                        ListNode endPosition = head;
                        while (endPosition != null) {
                            endPosition = endPosition.next;
                        }
                        sort(head, endPosition);
                        long end = System.nanoTime();
                        long sortTimeInNano = end - start;
                        double sortTimeIn10thSeconds = (double) sortTimeInNano / Math.pow(10, 8);
                        System.err.println("Time after sorting list in 10th of second: " + sortTimeIn10thSeconds);

                        while (head != null) {
                            output.println(head.data);
                            head = head.next;
                        }
                        output.println("Time after sorting list in 10th of second: " + sortTimeIn10thSeconds);

                    }
                }
            } else {
                System.out.println("Invalid filename, please enter a file name that ends with input.txt");
            }
            System.out.print("Enter a filename or Q to quit: ");
            filename = console.next().toLowerCase();
            head = null;
        }

    }

    public static void main(String[] args) {
        new Qsort();
    }

    // Returns Scanner for an input file
    // Returns null if the file does not exist
    /**
     * getInputScanner method is used to create a scanner of the input file the user
     * entered. It will return null and a FileNotFoundException if the user enters a
     * file that does not exist.
     *
     */
    public Scanner getInputScanner(String filename) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return fileScanner;
    }

    // Returns PrintStream for an output file
    // If the output file already exists, asks the user if it is OK to overwrite the
    // file
    // If it is not OK to overwrite the file or a FileNotFoundException occurs, null
    // is
    // returned instead of a PrintStream
    /**
     * getOutputPrintStream method is used to create a output files with the
     * opposite extentions. If the file already exists then it will prompt the user
     * if they want to overwrite the file If they respond no then the output will
     * return null. If file is unable to be written then it will prompt the user of
     * the error
     *
     */
    public PrintStream getOutputPrintStream(Scanner console, String filename) {
        PrintStream output = null;
        if (filename.endsWith("input.txt")) {
            filename = filename.substring(0, filename.length() - 9);
            filename = filename + "Qsort_output.txt";

        }
        File file = new File(filename);
        try {
            if (!file.exists()) {
                output = new PrintStream(file);
            } else {
                System.out.print(filename + " exists - OK to overwrite(y,n)?: ");
                String reply = console.next().toLowerCase();
                if (reply.startsWith("y")) {
                    output = new PrintStream(file);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File unable to be written " + e);
        }
        return output;
    }

    /*
     * process function takes in the input scanner and the goes line by line placing
     * the integer into the global list
     */
    public void process(Scanner input) {
        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            if (lineScan.hasNextInt()) {
                add(lineScan.nextInt());
            }
            lineScan.close();
        }

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
        size++;
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