public class MyLinkedList {

    /**
     * private field for size of the list and will be updated when a link is added
     * or removed
     */
    private int size;
    /** private field that is a ListNode that is for the front */
    private ListNode head = null;

    /**
     * Constructor for the LinkedList that instantiates two null nodes for the front
     * and the back and then makes front.next point to the back and the back.prev
     * point to the front.
     */
    public MyLinkedList() {
        size = 0;
    }

    /**
     * 
     * Inserts the specified element into the front
     * 
     * list (optional operation).
     * 
     * @param e is the element that is added to the list
     * 
     */

    public void add(int num) {
        ListNode newNode = new ListNode(num);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void add(int index, int num) {
        if (index < size) {
            ListNode currentNode = head;
            ListNode newNode = new ListNode(num);
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;

            size++;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void remove(int index) {
        ListNode previousNode = null;
        ListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode.next = currentNode.next;
        currentNode = currentNode.next;
        size--;
    }

    public Integer size() {
        return size;
    }

    // Method to print the LinkedList.
    public void printList(MyLinkedList list) {
        ListNode currentNode = list.head;

        while (currentNode != null) {
            // Print the data at current node
            System.out.print(currentNode.data + " ");

            // Go to next node
            currentNode = currentNode.next;
        }
        System.out.println();

    }

    private class ListNode {
        /** public field that holds the data of the linked list */
        public int data;

        public ListNode next;

        /**
         * Constructor method that takes in one parameter that creates a node with
         * information but the previous and next links are null
         * 
         * 
         */
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
