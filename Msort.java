import java.util.*;
import java.io.*;

public class Msort {
    MyLinkedList list = new MyLinkedList();

    public Msort() {
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
                        sort(0, list.size());
                        list.reverseList();
                        long end = System.nanoTime();
                        long sortTimeInNano = end - start;
                        double sortTimeIn10thSeconds = (double) sortTimeInNano / Math.pow(10, 7);
                        System.err.println("Time after sorting list in 10th of second: " + sortTimeIn10thSeconds);

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
            list = new MyLinkedList();
        }

    }

    public static void main(String[] args) {
        new Msort();
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
            filename = filename + "Msort_output.txt";

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
                list.add(lineScan.nextInt());
            }
            lineScan.close();
        }

    }

    public void merge(int beginList, int median, int endList) {
        // Creating two sublists that will be merged into one ordered list.
        MyLinkedList list1 = subList(beginList, median);
        MyLinkedList list2 = subList(median, endList);

        // New Temporary list that will be used at the end of this function to
        // update the global list.
        MyLinkedList listTmp = new MyLinkedList();
        int index1 = beginList;
        int index2 = median;

        // Use counters to move pointers in the sublists
        int count1 = 0;
        int count2 = 0;

        // While loop will run when both of the counters has not reached sublist size
        while (count1 < list1.size() && count2 < list2.size()) {
            // Add element from list1 to temporary list, when pointer in first list is less
            // than pointer in second sublist.
            // Increment pointer in first list afterwards
            if (list1.get(count1) < list2.get(count2)) {
                listTmp.add(list1.get(count1));
                ++count1;
            } else {
                // Element at second sublist pointer is smaller than first sublist pointer so
                // add element to
                // temporary list.
                // Increment pointer in second array afterwards.
                listTmp.add(list2.get(count2));
                ++count2;
            }

        }

        // In scenario where all elements in second sublist were added and some or no
        // elements were not added from first list. This if statement will go through
        // rest of the elements in first
        // sublist and append them to the temporary list.
        if (count1 < list1.size()) {
            while (count1 < list1.size()) {
                listTmp.add(list1.get(count1));
                count1++;
            }

        }
        // In scenario where all elements in first sublist were added and some or no
        // elements were not added from second list. This if statement will go through
        // rest of the elements in
        // second sublist and append them to the temporary list.
        if (count2 < list2.size()) {
            while (count2 < list2.size()) {
                listTmp.add(list2.get(count2));
                count2++;
            }
        }

        // Index1 and index2 are the first elements in their subarrays and their values
        // are their current position in the global list.
        // Whichever index is lower is the starting position where we will be setting
        // values of the temporary list into global list.
        if (index1 < index2) {
            for (int i = 0; i < listTmp.size(); i++) {
                list.set(index1, listTmp.get(i));
                index1++;
            }
        } else {
            for (int i = 0; i < listTmp.size(); i++) {
                list.set(index2, listTmp.get(i));
                index2++;
            }
        }

    }

    // This function is used to make sublists from the global list which we declared
    // at the top.
    public MyLinkedList subList(int beginList, int endList) {
        MyLinkedList tmp = new MyLinkedList();

        for (int i = beginList; i < endList; ++i) {
            tmp.add(list.get(i));
        }
        return tmp;
    }

    // Main function that will be called recursively to half our lists till lists
    // are one element. After halving, it will merge elements back together in
    // sorted order.
    public void sort(int beginList, int endList) {
        // first point to list head and list midpoint
        // next, recusivley call splitting at those pointers (each 1/2 list will be
        // split in half, again, etc ...)
        // then call merge on each of those lists
        int median = ((beginList + endList) / 2);

        int l1 = median - beginList;
        int l2 = endList - median;

        if (l1 > 0 && l2 > 0) {
            sort(beginList, median);
            sort(median, endList);
            merge(beginList, median, endList);
        }
    }

}