//
//  main.cpp
//  505-1
#include <iostream>
#include <list>
#include <string>
#include <stdlib.h>
#include<stdio.h>
#include <sstream>

using namespace std;

int main(int argc, const char * argv[]) {
   
    cout << "start main\n";
    string numstr;
    list<int> all_nodes;

    while (getline(cin, numstr)&& numstr.length() != 0){ // grab cin line by line, store in num
        
        //const char *num = atoi(numstr);// C++11 convert string to int
        
        //C++03 and older convert string to int
        stringstream ss(numstr);
        int num;
        ss >> num;
        all_nodes.push_back(num); //add num to end of list
    }
    
    //for (auto const& n: all_nodes) {cout << n << endl;} C++11
    
    //Print final list
        //for small test files to see output at terminal while we get started
            //larger files should be << to out file
    for (list<int>::iterator iter = all_nodes.begin(); iter != all_nodes.end(); ++iter){
        cout << *iter << endl; //
    }
    
    
    
} // end main
    





