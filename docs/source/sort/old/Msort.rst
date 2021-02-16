Msort
=====

.. java:package:: sort.old
   :noindex:

.. java:type:: public class Msort

Fields
------
list
^^^^

.. java:field::  LinkedList<Integer> list
   :outertype: Msort

Constructors
------------
Msort
^^^^^

.. java:constructor:: public Msort()
   :outertype: Msort

Methods
-------
getInputScanner
^^^^^^^^^^^^^^^

.. java:method:: public Scanner getInputScanner(String filename)
   :outertype: Msort

   getInputScanner method is used to create a scanner of the input file the user entered. It will return null and a FileNotFoundException if the user enters a file that does not exist.

getOutputPrintStream
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public PrintStream getOutputPrintStream(Scanner console, String filename)
   :outertype: Msort

   getOutputPrintStream method is used to create a output files with the opposite extentions. If the file already exists then it will prompt the user if they want to overwrite the file If they respond no then the output will return null. If file is unable to be written then it will prompt the user of the error

main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: Msort

merge
^^^^^

.. java:method:: public void merge(int beginList, int median, int endList)
   :outertype: Msort

process
^^^^^^^

.. java:method:: public void process(Scanner input)
   :outertype: Msort

sort
^^^^

.. java:method:: public void sort(int beginList, int endList)
   :outertype: Msort

subList
^^^^^^^

.. java:method:: public LinkedList<Integer> subList(int beginList, int endList)
   :outertype: Msort

