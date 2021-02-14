public class Dummy {
    private MyLinkedList list;

    public Dummy() {
        list = new MyLinkedList();
        list.add(3);
        list.add(2);
        list.add(0);
        list.add(1);
        list.add(6);
        list.add(5);

        list.printList(list);

        list.remove(1);
        list.remove(1);
        list.printList(list);
        list.add(3, 2);

        list.printList(list);

    }

    public static void main(String[] args) {
        new Dummy();
    }
}
