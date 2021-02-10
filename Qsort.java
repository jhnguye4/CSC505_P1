import java.util.*;

public class Qsort {
    LinkedList<Integer> list = new LinkedList<Integer>();

    public Qsort() {
        list.addFirst(11);
        list.addFirst(44);
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
        sort(0, list.size() - 1);
        System.out.println("List After Sort: " + list);

    }

    public static void main(String[] args) {
        new Qsort();
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