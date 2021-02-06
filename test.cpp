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

partition(list<int> &my_list)
{ // have to pass by reference
    cout << "hello from partition" << endl;
}

// void quicksort(list<int>& my_list, list<int>::iterator start, list<int>::iterator end){

//     list<int>::iterator begin_it = my_list.begin();
//     list<int>::iterator end_it = next(my_list.end(),-1);

//     list<int>::iterator pivot = partition(my_list, begin_it, end_it);
//     list<int>::iterator pivot1 = next(pivot,1);

//     quicksort(my_list,my_list.begin(), pivot); // is my_list updated tho?
//     quicksort(my_list,pivot1, next(my_list.end(),-1));

// }

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
    all_nodes.push_back(1);
    all_nodes.push_back(0);
    all_nodes.push_back(4);
    all_nodes.push_back(3);
    for (list<int>::iterator iter = all_nodes.begin(); iter != all_nodes.end(); ++iter)
    {
        cout << *iter << endl; //
    }
    cout << "\n";
    partition(&all_nodes);
    cout << "\n";
    // quicksort(all_nodes, all_nodes.begin(), next(all_nodes.end(), -1));

    //for (auto const& n: all_nodes) {cout << n << endl;} C++11

    //Print final lits
    //for small test files to see output at terminal while we get started
    //larger files should be << to out file
    for (list<int>::iterator iter = all_nodes.begin(); iter != all_nodes.end(); ++iter)
    {
        cout << *iter << endl; //
    }

} // end main