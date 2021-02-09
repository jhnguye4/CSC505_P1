import java.util.*;

public class Msort {
    LinkedList<Integer> list = new LinkedList<Integer>();

    public Msort() {
        list.addFirst(44);
        list.addFirst(11);
        //list.addFirst(22);
        //list.addFirst(55);
        // list.addFirst(77);
        // list.addFirst(0);
        // list.addFirst(77);
        // list.addFirst(5);
        // list.addFirst(35);
        // list.addFirst(99);
        // list.addFirst(77);
        System.out.println(list);
        sort(0, list.size());
        System.out.println(list);

    }

    public static void main(String[] args) {
        new Msort();
    }

    public LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2){

        LinkedList<Integer> listTmp = new LinkedList<Integer>();

        int count1 = 0;
        int count2 = 0;

        while (count1 < list1.size() && count2 < list2.size()){



            if(list1.get(count1) < list2.get(count2)){
                listTmp.add(list1.get(count1));
                ++count1;
            }
            else{
                listTmp.add(list2.get(count2));
                ++count2;
            }


        }
        //System.out.println(count1);
        //System.out.println(count2);

        if (count1 < list1.size()){
            listTmp.add(list1.get(count1));
        }
        if (count2 < list2.size()){
            listTmp.add(list2.get(count2));
        }

        System.out.println(listTmp);
        return listTmp;
    }

    public LinkedList<Integer> subList(int beginList, int endList) {
        LinkedList<Integer> tmp = new LinkedList<Integer> ();

        for (int i = beginList; i < endList; ++i){
            tmp.add(list.get(i));
        }
        return tmp;
    }

    public void sort(int beginList, int endList) {
        // first point to list head and list midpoint
        // next, recusivley call splitting at those pointers (each 1/2 list will be split in half, again, etc ...)
        // then call merge on each of those lists

        int median = (beginList + endList)/2;

        LinkedList<Integer> l1 = subList(beginList, median);
        LinkedList<Integer> l2 = subList(median, endList);


       // System.out.println(beginList);
        //System.out.println(endList);
        //System.out.println(median);
        
        // LinkedList <Integer> l1 = new LinkedList<Integer>();
        // LinkedList <Integer> l2 = new LinkedList<Integer>();
        // l1.add(22);
        // l1.add(55);
        // l1.add(66);
        // l2.add(11);
        // l2.add(44);
        // l2.add(77);
        if(beginList < endList && l1.size() > 1 && l2.size() > 1){
            sort(beginList, median);
            sort(median, endList);
            System.out.println(l1);
            System.out.println(l2);
            merge(l1, l2);
        }
        
        
       


        // LinkedList<Integer> l3 = sort(beginList, median);
        // LinkedList<Integer> l4 = sort(median+1, endList);
        //return merge(l3, l4); //merge sort's return lists

    }








}