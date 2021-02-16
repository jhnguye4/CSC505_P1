.. java:import:: java.util AbstractSequentialList

.. java:import:: java.util ListIterator

.. java:import:: java.util NoSuchElementException

AlgosLinkedList
===============

.. java:package:: sort
   :noindex:

.. java:type:: public class AlgosLinkedList<E> extends AbstractSequentialList<E>

   Custom implementation of a linked list that doesn’t allow for null elements or duplicate elements as defined by the equals() method.

   :author: jhnguye4
   :param <E>: the object that will be passed through the linked list

Constructors
------------
AlgosLinkedList
^^^^^^^^^^^^^^^

.. java:constructor:: public AlgosLinkedList()
   :outertype: AlgosLinkedList

   Constructor for the LinkedList that instantiates two null nodes for the front and the back and then makes front.next point to the back and the back.prev point to the front.

Methods
-------
add
^^^

.. java:method:: @Override public void add(int index, E element)
   :outertype: AlgosLinkedList

   This method adds an element to the LinkedList

   :param index: is the position where the new element will be placed
   :param element: is the data or object that will be stored in that link

listIterator
^^^^^^^^^^^^

.. java:method:: @Override public ListIterator<E> listIterator(int index)
   :outertype: AlgosLinkedList

   This method returns a LinkedListIterator with the index it will go to

   :param index: is the position that the iterator will move to
   :return: a new LinkedListIterator object

set
^^^

.. java:method:: @Override public E set(int index, E element)
   :outertype: AlgosLinkedList

   This method sets the element at the specified index

   :param index: is the position where the new element will be placed
   :param element: is the data or object that will be stored in that link
   :return: E is the object that is being replaced

size
^^^^

.. java:method:: @Override public int size()
   :outertype: AlgosLinkedList

   This method returns the size of the linked list

   :return: size is how big the linked list is

