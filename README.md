# CSC505_P1
CSC 505 Project 1: Sorting

## Learning Objective
Gain deeper understanding of (sorting) algorithms by implementing them in a non-traditional setting; explore the benefits and limitations of experimental analysis of algorithm behavior; demonstrate ability to manipulate linked lists; design experiments to test hypotheses about algorithm behavior; write a compelling comparative analysis based on experimental results.

## Specifications
Project will implement three sorting algorithms that will sort a linked list. The three sorting algorithms implemented are insertion sort, quicksort, and merge sort. The program will read in one integer per line from the command line and then output the same numbers in ascending order while also outputing the runtime and number of comparisons for each algorithm. 

## Running Program
In order to run sort with input files:

* ./run_short.sh insertion < ./test_files/test1_input.txt
* ./run_short.sh quick < ./test_files/test1_input.txt
* ./run_short.sh merge < ./test_files/test1_input.txt

In order to pipe values from random permutation file into sorting algorithm:

* ./random_permutation.py 1000 | ./run_short.sh insertion 
* ./random_permutation.py 1000 | ./run_short.sh quick 
* ./random_permutation.py 1000 | ./run_short.sh merge

If you do not want the sorted values to be outputed to the console:

* ./random_permutation.py 1000 | ./run_short.sh insertion > /dev/null