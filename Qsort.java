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
        System.out.println(list);
        sort(0, list.size() - 1);
        System.out.println(list);

    }

    public static void main(String[] args) {
        new Qsort();
    }

    public void swap(int index1, int index2) {
        int value1 = list.get(index1);
        int value2 = list.get(index2);
        int temp = value1;
        list.set(index1, value2);
        list.set(index2, temp);
    }

    public int partition(int start, int end) {
        // Randomizing pivot
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end - start) + start;
        int pivot = list.get(pivotIndex);

        // Moving pivot to front
        swap(pivotIndex, start);

        int j = start;
        for (int i = start + 1; i <= end; i++) {
            if (list.get(i) < pivot) {
                j++;
                swap(i, j);
            }
        }
        swap(j, start);
        return j;
    }

    public void sort(int lo, int hi) {
        if (lo < hi) {
            int lastPivot = partition(lo, hi);
            sort(lo, lastPivot - 1);
            sort(lastPivot + 1, hi);
        }

    }

}