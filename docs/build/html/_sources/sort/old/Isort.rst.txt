Isort
=====

.. java:package:: sort.old
   :noindex:

.. java:type:: public class Isort

Fields
------
list
^^^^

.. java:field::  LinkedList<Integer> list
   :outertype: Isort

Constructors
------------
Isort
^^^^^

.. java:constructor:: public Isort()
   :outertype: Isort

Methods
-------
getInputScanner
^^^^^^^^^^^^^^^

.. java:method:: public Scanner getInputScanner(String filename)
   :outertype: Isort

   getInputScanner method is used to create a scanner of the input file the user entered. It will return null and a FileNotFoundException if the user enters a file that does not exist.

getOutputPrintStream
^^^^^^^^^^^^^^^^^^^^

.. java:method:: public PrintStream getOutputPrintStream(Scanner console, String filename)
   :outertype: Isort

   getOutputPrintStream method is used to create a output files with the opposite extentions. If the file already exists then it will prompt the user if they want to overwrite the file If they respond no then the output will return null. If file is unable to be written then it will prompt the user of the error

main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: Isort

process
^^^^^^^

.. java:method:: public void process(Scanner input)
   :outertype: Isort

sort
^^^^

.. java:method:: public void sort()
   :outertype: Isort

