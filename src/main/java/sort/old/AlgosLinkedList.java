package sort.old;
/**
 * 
 */

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Custom implementation of a linked list that doesn’t allow for null elements
 * or duplicate elements as defined by the equals() method.
 * 
 * @author jhnguye4
 * @param <E> the object that will be passed through the linked list
 *
 */
public class AlgosLinkedList<E> extends AbstractSequentialList<E> {
	/**
	 * private field for size of the list and will be updated when a link is added
	 * or removed
	 */
	private int size;
	/** private field that is a ListNode that is for the front */
	private ListNode front;
	/** private field that is a ListNode that is for the back */
	private ListNode back;

	/**
	 * Constructor for the LinkedList that instantiates two null nodes for the front
	 * and the back and then makes front.next point to the back and the back.prev
	 * point to the front.
	 */
	public AlgosLinkedList() {
		front = new ListNode(null);
		back = new ListNode(null);
		front.next = back;
		back.prev = front;
		size = 0;
	}

	/**
	 * This method returns a LinkedListIterator with the index it will go to
	 * 
	 * @param index is the position that the iterator will move to
	 * @return a new LinkedListIterator object
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		return new LinkedListIterator(index);
	}

	/**
	 * This method adds an element to the LinkedList
	 * 
	 * @param index   is the position where the new element will be placed
	 * @param element is the data or object that will be stored in that link
	 */
	@Override
	public void add(int index, E element) {
		if (this.contains(element)) {
			throw new IllegalArgumentException("Duplicate Element");
		}
		super.add(index, element);
	}

	/**
	 * This method sets the element at the specified index
	 * 
	 * @param index   is the position where the new element will be placed
	 * @param element is the data or object that will be stored in that link
	 * @return E is the object that is being replaced
	 */
	@Override
	public E set(int index, E element) {
		if (this.contains(element)) {
			throw new IllegalArgumentException("Duplicate Element");
		}
		return super.set(index, element);
	}

	/**
	 * This method returns the size of the linked list
	 * 
	 * @return size is how big the linked list is
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * This inner class implements the ListIterator interface and its methods
	 * 
	 * @author jhnguye4
	 *
	 */
	private class LinkedListIterator implements ListIterator<E> {
		/** Represents the ListNode that would be returned on a call to previous() */
		public ListNode previous;
		/** Represents the ListNode that would be returned on a call to next() */
		public ListNode next;
		/**
		 * Represents the ListNode that was returned on the last call to either
		 * previous() or next() or null if a call to previous() or next() was not the
		 * last call on the ListIterator.
		 */
		private ListNode lastRetrieved;
		/** The index that would be returned on a call to previousIndex() */
		public int previousIndex;
		/** The index that would be returned on a call to nextIndex() */
		public int nextIndex;

		/**
		 * Constructor of the LinkedListIterator that will traverse through the linked
		 * list with next being the index and the previous being 1 before the index.
		 * 
		 * @param index is the position where the new element will be placed
		 */
		public LinkedListIterator(int index) {
			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException();
			}
			if (size == 0) {
				previous = front;
				next = back;
				return;
			}
			previous = front;
			next = front.next;
			for (int i = 0; i < index; i++) {
				next();
			}

			previousIndex = index - 1;
			nextIndex = index;
			lastRetrieved = null;
		}

		/**
		 * This method returns true if the next object is not null
		 * 
		 * @return boolean true if there is an object after the current one
		 */
		@Override
		public boolean hasNext() {
			if (next != back) {
				return true;
			}
			return false;
		}

		/**
		 * This method returns the data of the current cursor and then moves it to the
		 * next.
		 * 
		 * @return E the data that is returned before the cursor moves
		 */
		@Override
		public E next() {
			if (next == null) {
				throw new NoSuchElementException();
			}

			lastRetrieved = next;
			E data = next.data;
			previous = next;
			next = next.next;
			if (next == null) {
				throw new IndexOutOfBoundsException();
			}
			previousIndex++;
			nextIndex++;
			return data;
		}

		/**
		 * This method returns true if there is a previous object
		 * 
		 * @return boolean true if there is a previous object
		 */
		@Override
		public boolean hasPrevious() {
			if (previous != front) {
				return true;
			}
			return false;
		}

		/**
		 * This method returns the data of the current cursor and then moves it to the
		 * previous.
		 * 
		 * @return E the data that is returned before the cursor moves
		 */
		@Override
		public E previous() {
			if (previous == null) {
				throw new NoSuchElementException();
			}

			lastRetrieved = previous;
			E data = previous.data;
			previous = previous.prev;
			next = next.prev;
			previousIndex--;
			nextIndex--;
			return data;
		}

		/**
		 * Returns an int of the next index
		 * 
		 * @return int of the next index
		 */
		@Override
		public int nextIndex() {
			return nextIndex;
		}

		/**
		 * Returns an int of the previous index
		 * 
		 * @return int of the previous index
		 */
		@Override
		public int previousIndex() {
			return previousIndex;
		}

		/**
		 * Removes from the list the last element that was returned by next() or
		 * previous()
		 */
		@Override
		public void remove() {
			if (lastRetrieved == null) {
				throw new IllegalArgumentException();
			}

			previous.next = lastRetrieved.next;
			next.prev = lastRetrieved.prev;
			size--;
			previousIndex--;
			nextIndex--;
			lastRetrieved = null;

		}

		/**
		 * Replaces the last element returned by next() or previous() with the specified
		 * element
		 * 
		 * @param e is the element that is going to replace the last element from next
		 *          or previous
		 */
		@Override
		public void set(E e) {
			if (lastRetrieved == null) {
				throw new IllegalArgumentException();
			}
			if (e == null) {
				throw new NullPointerException();
			}
			if (size == 0) {
				throw new IndexOutOfBoundsException();
			}
			lastRetrieved.data = e;

		}

		/**
		 * Inserts the specified element into the list (optional operation). The element
		 * is inserted immediately before the element that would be returned by next(),
		 * if any, and after the element that would be returned by previous(), if any.
		 * 
		 * @param e is the element that is added to the list
		 */
		@Override
		public void add(E e) {
			if (e == null) {
				throw new NullPointerException();
			}
			ListNode newNode = new ListNode(e, previous, next);
			next.prev = newNode;
			previous.next = newNode;
			previous = newNode;

			previousIndex++;
			nextIndex++;
			lastRetrieved = null;
			size++;
		}

	}

	/**
	 * private inner class that creates Nodes for the linked list
	 * 
	 * @author jhnguye4
	 *
	 */
	private class ListNode {
		/** public field that holds the data of the linked list */
		public E data;
		/** public field for the next ListNode */
		public ListNode next;
		/** public field for the prev ListNode */
		public ListNode prev;

		/**
		 * Constructor method that takes in one parameter that creates a node with
		 * information but the previous and next links are null
		 * 
		 * @param data the data that the new node will hold
		 */
		public ListNode(E data) {
			this(data, null, null);
		}

		/**
		 * Constructor method that takes in three parameters to create a node and link
		 * it to the previous link and the next linke
		 * 
		 * @param data the data that the new node will hold
		 * @param prev points to the previous link
		 * @param next points to the next link
		 */
		public ListNode(E data, ListNode prev, ListNode next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

}
