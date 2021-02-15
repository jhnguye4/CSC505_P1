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

        list.printList();

        list.remove(1);
        list.remove(1);
        list.add(0, 2);
        list.printList();
        list.set(0, 4);
        list.set(4, 6);
        list.printList();
        list.addEnd(8);
        list.printList();

    }

    public static void main(String[] args) {
        new Dummy();
    }
}
