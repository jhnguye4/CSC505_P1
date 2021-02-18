#!/bin/bash

if [[ "$1" == "insertion" ]]; then
    javac Isort.java
    java Isort $2
elif [[ "$1" == "quicksort" ]]; then
    javac Qsort.java
    java Qsort $2
elif [[ "$1" == "mergesort" ]]; then
    javac Msort.java
    java Msort $2
fi