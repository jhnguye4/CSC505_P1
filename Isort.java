import java.util.*;

public class Is {
    LinkedList<Integer> list = new LinkedList<Integer>();

    public Is() {
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
        sort();
        System.out.println(list);

    }

    public static void main(String[] args) {
        new Is();
    }



    public void sort() {

        int i = 1;
        //System.out.println(list);
        while (i <= list.size()-1) {
            
            int count = 0;
            for (int k = i-1; k >= 0; --k){    
                if (list.get(i) < list.get(k)){
                ++count;
                }
            }

            int tmp = list.get(i);
            list.remove(i);
            list.add(i-count,tmp);
            System.out.println(list);
            ++i;
            
        }
    }
}