import java.util.*;

public class Isort {
    LinkedList<Integer> list = new LinkedList<Integer>();

    public Isort() {
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
        sort();
        System.out.println("List After Sort: " + list);
    }

    public static void main(String[] args) {
        new Isort();
    }

    /*
     * The idea of insertion sort is that it will go through each element in the
     * list. At each element, it will then look at each element backwards to see if
     * it is less. It will keep moving back for each element it is less than and
     * then be inserted at the final position where it will shift all the other
     * elements down. This algorithm is normally time consuming if you are using an
     * array and need to shift each element down the array to insert, for this
     * situation we used a linkedlist so all we had to do was unlink the pointers
     * and relink it where it needed to be inserted. This algorithms worst case is
     * O(n^2), and is normally used for smaller data sets.
     */
    public void sort() {
        // Declared i as 1 since we cant compare any elements before the first element.
        int i = 1;

        // Going through each element of the array from the second element to the end
        while (i < list.size()) {

            // Counter that will be used to see how many elements back we have to move the
            // element at i
            int count = 0;

            // k is set to the index before i and will be decremented till it reaches the
            // first element.
            for (int k = i - 1; k >= 0; --k) {
                // Count will be incremented when value at k is greater than the value we are
                // trying to insert.
                if (list.get(i) < list.get(k)) {
                    ++count;
                }
            }

            // Procedure in order to unlink insertion value and move it an x amount back.
            int tmp = list.get(i);
            list.remove(i);
            list.add(i - count, tmp);
            ++i;
        }
    }
}