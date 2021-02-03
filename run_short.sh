#!/bin/bash 

g++ main.cpp -o main
#make main
./main | random_permutation.py

exit 0
