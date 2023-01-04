## Bucket Sort

Another sorting algorithm that achieve linear running time O(n) in average case. *only one i didn't implement :/*

### Algorithm

bucket sort assumes that the input is generated
by a random process that distributes elements uniformly and independently over
the interval [0,1]

steps for bucket sort:

* create an array of Linked Lists, where each index stores a range of elements
* add each element to the bucket it belongs to
* sort each bucket sccordingly using insertion sort
* merge all buckets together in order

### Analysis

bucket sort take an average-case O(n). Let's look at the analysis in depth

we have k buckets, and our initial array to-be-sorted is of size n

All operations described in the algorithm take O(n) in the worst case except for insertion sort.

#### Best case

it's when the elements are uniformly distributed; i,e,. ~all buckets have the same number of elements= $n/k$.
In this case, sorting each will have a worst-case of $n^2/k$.
we'll have the following: 

* sorting each bucket: $n^2/k$
* creating buckets: n
* merging: k

O( $n^2/k+n+k$ )=O( $n^2$ )

it becomes linear when sorting takes linear time (already sorted)

#### Worst case

All elements fall into the same bucket AND in reverse order :)

### Notes

#### Sorting buckets

to enhance a worst case of O( $n^2$ ), go for more efficient sorting algorithms such as quick, merge and heap sort that can take linearlogarithmic (quicksort not really but okay). In this case, Linked List are no longer used but rather buckets become arrays. Linked Lists are especially useful for insertion sort (limit number of swaps). However, this will slow down the sorting process, this is why we stick with insertion.
