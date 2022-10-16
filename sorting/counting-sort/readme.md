## Counting sort

This sorting algorithm presents a way to sort an array of elements (of one digit) in linear time. It's usually used as a subroutine for radix sort.

### Algorithm 

It's not in place, however it's stable. It starts by creating an array C of size=max element in our array A (call it k) and instanciate its values to 0.

Filling elements in C:

* for each element in A (and since it's value is an index in C) increment its corresponding index by 1
* increment the values of each element by the value of its preceding one (C[i]+=C[i-1] for i>0)

Create an array B of size n (same size as A) of which we wanna store our elements in a sorted way and fill the elements using the following:
```
for i=n-1 -->1:
  B\[C\[A\[J]]]=A\[J];
  C\[A\[J]]--;
```

okay this is it :) easy

### Analysis

* **find_max**: takes O(n)
* **fill_C**: takes O(k)
* **increment_C**: takes O(k)
* **fill_B**: takes O(n)

The running time of Counting sort is O(n+k). in practice we usually use it when k=O(n) making the running time linear.

### Notes

#### Stable 

one of the advantages of counting sort is that it's stable: meaning, elements already put in a particular order in the original unsorted array will stay in this particular order without shuffeling.

*proof*:

Take 2 equal elements at different indeces i and j where i<j. 
After sorting, the one that was at index i will still be at an index< than the one that was on index j.

When filling B, if the loop gows up from 1--> A.length, the array will still be perfectly sorted but will no longer be stable: 
Equal elements will appear in reverse order in the sorted array

#### Radix

This algorithm is especially useful for radix sort, since in most problems sorting an array consisting of units elements is not really useful.
