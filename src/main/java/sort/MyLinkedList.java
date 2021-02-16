
package sort;

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
            if (index == 0) {
                this.add(num);
                return;
            }
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

    public Integer get(int index) {
        ListNode currentNode = head;
        if (index < size) {
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            throw new IllegalArgumentException();
        }
        return currentNode.data;
    }

    public void set(int index, int value) {
        ListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = value;
    }

    public Integer size() {
        return size;
    }

    public void swap(int index1, int index2) {
        ListNode position1 = head;
        ListNode position2 = head;
        for (int i = 0; i < index1; i++) {
            position1 = position1.next;
        }
        for (int i = 0; i < index2; i++) {
            position2 = position2.next;
        }
        int temp = position1.data;
        position1.data = position2.data;
        position2.data = temp;
    }

    public void reverseList() {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
    }

    // Method to print the LinkedList.
    public void printList() {
        ListNode currentNode = head;

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
