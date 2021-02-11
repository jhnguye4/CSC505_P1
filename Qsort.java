import java.util.*;
import java.io.*;

public class Qsort {
    LinkedList<Integer> list = new LinkedList<Integer>();

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
                        System.out.println("List Before Sort: " + list);
                        sort(0, list.size() - 1);
                        System.out.println("List After Sort: " + list);

                        for (int i = 0; i < list.size(); i++) {
                            output.println(list.get(i));
                        }
                    }
                }
            } else {
                System.out.println("Invalid filename, please enter a file name that ends with input.txt");
            }
            System.out.print("Enter a filename or Q to quit: ");
            filename = console.next().toLowerCase();
            list = new LinkedList<Integer>();
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
                list.addFirst(lineScan.nextInt());
            }
            lineScan.close();
        }

    }

    // Function that swaps values at the two indexes of the global list.
    public void swap(int index1, int index2) {
        int value1 = list.get(index1);
        int value2 = list.get(index2);
        int temp = value1;
        list.set(index1, value2);
        list.set(index2, temp);
    }

    // Function that does most of the heavy lifting for this sorting algorithm. The
    // idea of partition is that it will randomly select a pivot and move all
    // elements that are smaller than the pivot to the left and elements greater
    // than the pivot to the right.
    public int partition(int start, int end) {
        // Randomizing pivot
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start) + start;
        int pivot = list.get(pivotIndex);

        // Moving pivot to front
        swap(pivotIndex, start);

        // Second pointer to the smaller element.
        int j = start;
        for (int i = start + 1; i <= end; i++) {
            // Checks if the pointer at i is less than pivot,
            // swaps the values at pointer i and j.
            // Then moves pointer j forward.
            if (list.get(i) < pivot) {
                j++;
                swap(i, j);
            }
        }
        // After while loop, the algorithm wants to move the pivot, which is at the
        // front,
        // to the last element that the j pointer is pointing to. By swapping the pivot
        // with this pointer, the pivot will be at the position where all elements
        // smaller than it will be to the left and all elements larger will be to the
        // right.
        swap(j, start);

        // Returns the position where the pivot is located.
        return j;
    }

    // Function that is recursively called inorder to break the list into smaller
    // portions so that it can be sorted.
    public void sort(int lo, int hi) {
        // Will only recursively call if the beginning element is at an index smaller
        // than the last element
        if (lo < hi) {
            int lastPivot = partition(lo, hi);
            sort(lo, lastPivot - 1);
            sort(lastPivot + 1, hi);
        }

    }

}