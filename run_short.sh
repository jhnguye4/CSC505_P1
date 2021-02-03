#!/bin/bash 

g++ main.cpp -o main
#make main
./main | python random_permutation.py

exit 0
