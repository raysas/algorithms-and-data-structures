## Insertion Sort

### Algorithm

Insertion sort is one of the simplest sorting algotithms. It mainly constitutes of inserting each element A[i] in its right position in the previous part of the array ( A\[0:i-1]).

It's constituted from a series of **Comparisons** and **Swaps** that will be analyzed later in the [Analysis](#analysis) of the algorithm.

#### Iterative Solution

##### Pseudocode

``` insertion(int[] arr, int left, int right):
    for i:=l+1-->r
      for j=i;j>=0;j--
        if arr[j]<arr[i]
          swap(i,j)
         else
          break
```

### Analysis

This algorithm is not the best algorithm to sort an array, it takes Polynomial Time O( $n^2$ ).
In order to study its *order of growth* we must study the *number of comparisons* and the *number of swaps*. 
**p.s. swapping takes constant time O(1).**

*Here's an illustration*

Suppose we're starting with this array of size n=5:

                        
| 8 | 5 | 3 | 7 | 4 |
|---|---|---|---|---|

step 1:
* take key=5
  * compare it with item directly before it: 8 --> smaller then swap

a maximum of 1 compare and swap in step one

| 5 | 8 | 3 | 7 | 4 |
|---|---|---|---|---|

step 2:
* take key=3
  * compare it with item directly before it: 8 --> smaller then swap
  * compare it with item directly before it: 5 --> smaller then swap

a maximum of 2 compares and swaps in step 2

| 3 | 5 | 8 | 7 | 4 |
|---|---|---|---|---|

step 3:
* take key=7
  * compare it to item directly before it: 8 --> smaller then swap
  * compare it to item directly before it: 5 --> larger then break and don't compare anymore

a maximum of 3 compares and swaps in step 3

| 3 | 5 | 7 | 8 | 4 |
|---|---|---|---|---|

step 4: 
* take key=4
  * compare it to item directly before it: 8 --> smaller then swap
  * compare it to item directly before it: 7 --> smaller then swap
  * compare it to item directly before it: 5 --> smaller than swap
  * compare it to item directly before it: 3 --> larger then break and don't compare anymore

a maximum of 4 compares and swaps in step 4

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

total number of steps: n

number of compares and number of swaps are quivalent: n

since we're repeating n steps in which each may have n compares and swaps, the **time complexity is O( $n^2$ )**

### Notes:

#### Running Time is affected by input

For this particular sorting algorithm, a *partially sorted* array will take less time to sort, and in this case a *sorted* array will take O(n).


partially sorted array is:
* each entry is not too far from its final position
* small array appended to a large sorted array
* only few entries not in place

#### Binary Insertion Sort

Assume compares are more expensive than swaps: 
a change to the algorithm that would decrease the time complexity would be: **Binary Search**

* turns into O ( $n log(n)$ )
* binary search on A\[0:i-1] sorted part of the array which take O (log i) times

Not practical, inserting will require shifting --> go back to the worst possible run time of the algori
