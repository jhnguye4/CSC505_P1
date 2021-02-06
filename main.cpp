//
//  main.cpp
//  505-1
#include <iostream>
#include <list>
#include <string>
#include <stdlib.h>
#include <stdio.h>
#include <sstream>
#include <cmath>
#include <algorithm>

using namespace std;

void printList(list<int> &my_list)
{
    cout << "\n"
         << endl;
    cout << "Printing List"
         << endl;
    for (list<int>::iterator iter = my_list.begin(); iter != my_list.end(); ++iter)
    {
        cout << *iter << " "; //
    }
    cout << "\n"
         << endl;
}
list<int>::iterator randomPivot(list<int> &my_list)
{
    srand(time(0));
    int random = rand();
    int value = random % my_list.size();
    return next(my_list.begin(), value);
}

list<int>::iterator partition(list<int> &my_list, list<int>::iterator &start, list<int>::iterator &end)
{ // have to pass by reference

    list<int>::iterator _start = start;
    list<int>::iterator _end = --end;

    int max = *max_element(_start, _end);
    int min = *min_element(_start, _end);
    list<int>::iterator pivot = randomPivot(my_list);
    cout << "pivot " << *pivot << endl;
    cout << "start " << *_start << endl;
    printList(my_list);

    my_list.push_front(*pivot);
    my_list.erase(pivot);
    // ++_start;
    cout << "pivot " << *pivot << endl;
    cout << "start " << *_start << endl;
    printList(my_list);

    int leftCount = 0;
    int rightCount = my_list.size() - 1;

    while (leftCount <= rightCount)
    {
        //this does not work, the = in <= makes it infinite
        while ((leftCount <= rightCount) && (*_start < *my_list.begin()))
        {
            ++leftCount;
            ++_start;
        }

        while ((leftCount <= rightCount) && (*_end > *my_list.begin()))
        {
            --rightCount;
            --_end;
        }

        if (leftCount <= rightCount)
        {
            cout << "LCount" << leftCount << endl;
            cout << "RCount" << rightCount << endl;
            cout << "before swapping" << endl;
            cout << "startb " << *_start << endl;
            cout << "endb " << *_end << endl;
            printList(my_list);
            swap(*_start, *_end);
            cout << "starta " << *_start << endl;
            cout << "enda " << *_end << endl;
            _start++;
            _end--;
            cout << "after swapping" << endl;
            printList(my_list);
        }
        swap(*my_list.begin(), *_end);
        cout << "new list after iteration" << endl;
        printList(my_list);
    }
    printList(my_list);
    return end;
}

void quicksort(list<int> &my_list, list<int>::iterator start, list<int>::iterator end)
{

    list<int>::iterator begin_it = my_list.begin();
    list<int>::iterator end_it = my_list.end();

    list<int>::iterator pivot = partition(my_list, begin_it, end_it);
    list<int>::iterator pivot1 = next(pivot, 1);

    // quicksort(my_list, my_list.begin(), pivot); // is my_list updated tho?
    // quicksort(my_list, pivot1, next(my_list.end(), -1));
}

int main(int argc, const char *argv[])
{

    cout << "start main\n";
    //    string numstr;
    list<int> all_nodes;
    //
    //    while (getline(cin, numstr)&& numstr.length() != 0){ // grab cin line by line, store in num
    //
    //        //const char *num = atoi(numstr);// C++11 convert string to int
    //
    //        //C++03 and older convert string to int
    //        stringstream ss(numstr);
    //        int num;
    //        ss >> num;
    //        all_nodes.push_back(num); //add num to end of list
    //    }
    //

    all_nodes.push_back(0);
    all_nodes.push_back(3);
    all_nodes.push_back(2);
    all_nodes.push_back(4);
    all_nodes.push_back(1);
    printList(all_nodes);

    quicksort(all_nodes, all_nodes.begin(), all_nodes.end());

    //for (auto const& n: all_nodes) {cout << n << endl;} C++11

    //Print final list
    //for small test files to see output at terminal while we get started
    //larger files should be << to out file

} // end main
