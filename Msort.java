import java.util.*;

public class Msort {
    LinkedList<Integer> list = new LinkedList<Integer>();

    public Msort() {
        list.addFirst(44);
        list.addFirst(11);
        list.addFirst(22);
        list.addFirst(55);
        list.addFirst(77);
        list.addFirst(0);
        list.addFirst(77);
        list.addFirst(5);
        list.addFirst(35);
        list.addFirst(99);
        list.addFirst(77);
        System.out.println("List Before Sort: " + list);
        sort(0, list.size());
        System.out.println("List After Sort: " + list);

    }

    public static void main(String[] args) {
        new Msort();
    }

    public void merge(int beginList, int median, int endList) {
        // Creating two sublists that will be merged into one ordered array.
        LinkedList<Integer> list1 = subList(beginList, median);
        LinkedList<Integer> list2 = subList(median, endList);

        // New Temporary list that will be used at the end of this function to
        // update the global list.
        LinkedList<Integer> listTmp = new LinkedList<Integer>();
        int index1 = beginList;
        int index2 = median;

        // Use counters to move pointers in the sublists
        int count1 = 0;
        int count2 = 0;

        // While loop will run when both the subarrays have not reached their sizes
        while (count1 < list1.size() && count2 < list2.size()) {
            // Add element from list1 to temporary list, when pointer in first list is less
            // than pointer in second sublist.
            // Increment pointer in first list afterwards
            if (list1.get(count1) < list2.get(count2)) {
                listTmp.add(list1.get(count1));
                ++count1;
            } else {
                // Element at second sublist pointer is smaller than first so add element to
                // temporary list.
                // Increment pointer in second array afterwards.
                listTmp.add(list2.get(count2));
                ++count2;
            }

        }

        // In scenario where all elements in second sublist were added and some or no
        // elements were not added from
        // first list, this if statement will go through rest of the elements in first
        // sublist and append them to the
        // temporary list.
        if (count1 < list1.size()) {
            while (count1 < list1.size()) {
                listTmp.add(list1.get(count1));
                count1++;
            }

        }
        // In scenario where all elements in first sublist were added and some or no
        // elements were not added from
        // second array, this if statement will go through rest of the elements in
        // second sublist and append them to the
        // temporary list.
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
    // at the top
    public LinkedList<Integer> subList(int beginList, int endList) {
        LinkedList<Integer> tmp = new LinkedList<Integer>();

        for (int i = beginList; i < endList; ++i) {
            tmp.add(list.get(i));
        }
        return tmp;
    }

    // Main function that will be called recursively to half our lists till lists
    // are one element.
    // After halving, it will merge elements back together in sorted order.
    public void sort(int beginList, int endList) {
        // first point to list head and list midpoint
        // next, recusivley call splitting at those pointers (each 1/2 list will be
        // split in half, again, etc ...)
        // then call merge on each of those lists
        int median = ((beginList + endList) / 2);

        LinkedList<Integer> l1 = subList(beginList, median);
        LinkedList<Integer> l2 = subList(median, endList);

        if (l1.size() > 0 && l2.size() > 0) {
            sort(beginList, median);
            sort(median, endList);
            merge(beginList, median, endList);
        }
    }

}