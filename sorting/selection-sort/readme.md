## Selection sort

### Algorithm

Algorithm mainly constitues of the following steps:

* Take the first element of the unsorted part of the array
* Search for the lowest element in this part of the array
* Swaps it with the first one

It's constituted from a series of **Comparisons** and **Swaps** that will be analyzed later in the [Analysis](#analysis) of the algorithm.

#### Iterative Solution

##### Pseudocode

``` selection(int[] arr, int left, int right):
    for i:=l-->r-1
      min=i
      for j:=i+1-->r
        if arr[j]<min
          min=arr[j]
      swap(i,min)
```

### Analysis

This algorithm is not the best algorithm to sort an array, it takes Polynomial Time O( $n^2$ ).
In order to study its *order of growth* we must study the *number of comparisons* and the *number of swaps*. 
**p.s. swapping takes constant time O(1).**

*Here's an illustration*

Suppose we're starting with this array of size n=5:

                        
| 8 | 5 | 3 | 7 | 4 |
|---|---|---|---|---|


The outer loop iterates n-1=4 times; these are the results of each iteration

* 1st iteration:
  * starts by comparing the first item 8 to the second item 5   --> sets minimum to 5
  * proceeds by comparing the minimum 5 to the third item 3     --> sets minimum to 3
  * proceeds by comparing the minimum 3 to the fourth item 7    --> no change
  * proceeds by comparing the minimum 3 to the last item 4      --> no change
  * finishes by swapping the minimum 3 with the first item 8

now the 3 belongs to the sorted part of the array and the unsorted part of the array starts from 5

we get this:

| 3 | 5 | 8 | 7 | 4 |
|---|---|---|---|---|
                       
*notice for the first iteration we had n - 1 comparisons and 1 swap.*

* 2nd iteration:
  * starts by comparing the first item in the unsorted part 5 to the second item 8   --> no change
  * proceeds by comparing the minimum 5 to the third item 7     --> no change
  * proceeds by comparing the minimum 5 to the fourth item 4    --> sets minimum to 4
  * finishes by swapping the minimum 4 with the first item 5    

we get this:

| 3 | 4 | 8 | 7 | 5 |
|---|---|---|---|---|

*notice for the second iteration we had n - 2 comparisons and 1 swap.*

* 3rd iteration:
  * starts by comparing the first item in the unsorted part 8 to the second item 7   --> set minimum to 7
  * proceeds by comparing the minimum 7 to the third item 5     --> sets minimum to 5
  * finishes by swapping the minimum 5 with the first item 8    

we get this:

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

*notice for the third iteration we had n - 3 comparisons and 1 swap.*

* 2nd iteration:
  * starts by comparing the first item in the unsorted part 7 to the second item 8   --> no change
  * finishes by swapping the minimum 7 with the first item 7 (no need for swapping but it won't really make a difference)

we still have this:

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

*notice for the forth and last iteration we had n - 4=n - n= 1 comparisons and 1 swap.* We can conclude the following:

* **Number of Comparisons**: 
 notice the arithmetic series
  * starts from n-1 compare operations in the 1st iteration
  * ends with 1 compare iteration in the laste iteration
  * note that we have n-1 iteration
  * we get the following series as the number of comparisons: 
 
 $$\sum_{k=1}^{n-1} k = n(n-1)/2$$
 
 * **Number of swaps:**
  we have a simple summation here
  * each iteration takes 1 swap
  * we have n-1 iterations
  * we get the following as number of swaps

$$n-1$$

**Conclusion**: This algorithm runs in O( $n^2$ )
