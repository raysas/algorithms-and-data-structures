## Radix Sort

a famous sorting algo (not a comparison one) that can come across linear time, takes counting sort as a subroutine.

### Algorithm

So radix sort consists of sorting the array on several stages beginning by sorting the numbers based on their least significant digit all the way to their most significant one.

Hence, we use a **loop of range the max number of digits d.**

* m=getMax(): function that returns max element of an array (runs in O(n))
* s=Integer.toString(m): truns the max element into a string
* d=s.length(): d is equal to the number of characters (in this context, digits) in the string corresponding to the max element

Another note in the implementation process, radix may need to use a modified counting-sort as the helper method that takes both the array to sort and the number of the digit we're sorting on in each particular invokation of the counting-sort

* take 0 as units, 1 as tens, 2 as hundreds and so on...
* notice the pattern: untits are $10^0$ , tens are $10^1$ ...

### Analysis

Radix sort can really be efficient, can be even of linear time with a running time of O(d(n+K)) for each:

* d is the number of digits
* n is the number of elemnts to sort
* k is the highest number of a digit used to create an array in each iteration and counting-sort process

### Notes

#### Sub-routine

usually, counting sort is used as the subroutine, but other sorting algorithms can be used as well. Note that the sorting algorithm should be ***stable***.
