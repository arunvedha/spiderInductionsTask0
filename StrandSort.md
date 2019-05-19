# Strand Sort

Strand Sort is a very simple recursive sorting algorithm that sorts items of a list into increasing order. 


## Working of algorithm

i.The algorithm first moves the first element of a list into a sub-list.

ii.It then compares the last element in the sub-list to each subsequent element in the original list.

iii.Once there is an element in the original list that is greater than the last element in the sub-list, the element is removed from the original list and added to the sub-list.

iv.This process continues until the last element in the sub-list is compared to the remaining elements in the original list.The sub-list is then merged into a new list.

v.Repeat this process and merge all sub-lists until all elements are sorted.


## Methodology in a problem


    1.Let ip[] be input list and op[] be output list.
    
    2.Create an empty sublist and move first item of ip[] to it.
    
    3.Traverse remaining items of ip. For every item x, check if x is greater than last inserted item to sublist. If yes, remove x from ip and add at the end of sublist. If no, ignore x (Keep it it in ip).
    
    4.Merge sublist into op (output list).
    
    5.Recur for remaining items in ip and current items in op.
 
 ### Example
   
a.Let ip[] = {10, 5, 30, 40, 2, 4, 9}

b.Initialize : op[] = {} sublist[] = {}

c.Move first item of ip to sublist.

d.sublist[] = {10}

e.Traverse remaining items of ip and if current element is greater than last item of sublist, move this item from ip to sublist. 

f.Now sublist[] = {10, 30, 40} ip[] = {5, 2, 4, 9}

g.Merge sublist into op. op = {10, 30, 40}

h.Next recursive call:

i.Move first item of ip to sublist. sublist[] = {5}

j.Traverse remaining items of ip and move elements greater than last inserted.

k.ip[] = {2, 4} sublist[] = {5, 9}

l.Merge sublist into op. op = {5, 9, 10, 30, 40}

m.Last Recursive Call:

n.{2, 4} are first moved to sublist and then merged into op.

o.op = {2, 4, 5, 9, 10, 30, 40}


### C++ code of the above illustration

#include <bits/stdc++.h> 

using namespace std; 
  
void strandSort(list<int> &ip, list<int> &op) 

{ 

// Base case : input is empty 

    if (ip.empty())                                            
    
        return; 
  
    list<int> sublist;                                        // Create a sorted sublist with first item of input list as first item of the sublist 
    
    sublist.push_back(ip.front()); 
    
    ip.pop_front();                                           
       
    for (auto it = ip.begin(); it != ip.end(); )             // If current item of input list is greater than last added item to sublist, move current item to sublist as sorted order is maintained.
    
    {           
  
        if (*it > sublist.back()) {                         // erase() on list removes an item and returns iterator to next of removed item.
        
            sublist.push_back(*it);  
  
            it = ip.erase(it); 
        } 
  
        else                                               // Otherwise ignore current element 
        
            it++; 
            
    } 
  
    op.merge(sublist);                                    // Merge current sublist into output 
  
    strandSort(ip, op);                                   // Recur for remaining items in input and current items in op.
    
} 

// Main function

int main(void)                                            

{ 

    list<int> ip{10, 5, 30, 40, 2, 4, 9}; 
  
    list<int> op;                                        // To store sorted output list 
 
    strandSort(ip, op);                                  // To store sorted output list 
  
    for (auto x : op)                                    // Printing the sorted list 
    
        cout << x << " "; 
        
    return 0; 
    
} 

### Output

2 4 5 9 10 30 40


## Complexity Analysis

### Time Complexity :-
    Worst time complexity : O(n^2) { when input list is reversely sorted }
    Best time complexity : O(n) { when input list is already sorted }
    
### Space complexity :- 
O(n)
