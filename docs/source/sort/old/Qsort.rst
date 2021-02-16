Qsort
=====

.. java:package:: sort.old
   :noindex:

.. java:type:: public class Qsort

Fields
------
list
^^^^

.. java:field::  LinkedList<Integer> list
   :outertype: Qsort

Constructors
------------
Qsort
^^^^^

.. java:constructor:: public Qsort()
   :outertype: Qsort

   Asking user to input a text file that ends with input.txt and with a single integer on each line

Methods
-------
getInputScanner
^^^^^^^^^^^^^^^

.. java:method:: public Scanner getInputScanner(String filename)
   :outertype: Qsort

   getInputScanner method is used to create a scanner of the input file the user entered. It will return null and a FileNotFoundException if the user enters a file that does not exist.

getOutputPrintStream
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public PrintStream getOutputPrintStream(Scanner console, String filename)
   :outertype: Qsort

   getOutputPrintStream method is used to create a output files with the opposite extentions. If the file already exists then it will prompt the user if they want to overwrite the file If they respond no then the output will return null. If file is unable to be written then it will prompt the user of the error

main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: Qsort

partition
^^^^^^^^^

.. java:method:: public int partition(int start, int end)
   :outertype: Qsort

process
^^^^^^^

.. java:method:: public void process(Scanner input)
   :outertype: Qsort

sort
^^^^

.. java:method:: public void sort(int lo, int hi)
   :outertype: Qsort

swap
^^^^

.. java:method:: public void swap(int index1, int index2)
   :outertype: Qsort

