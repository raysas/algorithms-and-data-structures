## Shell Sort

### Algorithm

This algorithm is based on [**Insertion Sort**](../insertion-sort)
Insertion Sort only swaps adjacent items, but Shell Sort allow swaps that range far apart to produce *partially sorted* arrays.

Algorithm mainly constitutes of **rearranging** the array starting from any hth entry and yields a *sorted subsequence*.

Note that This spacing is termed as interval. This interval is calculated based on Knuth's formula but in cp3 lab we took the initial interval to be n/2 for n is the length of my array (input size).

#### Pseudocode

```
shell(int[] a, int r, int l)
  boolean sorted=false;
  while (gap>=1 and !sorted)
    sorted=true;
    for i:=gap-->l-1
      int k=i;
      for int j=i-gap;j>=0;j=j-gap
        if a[j]>a[i]
          swap(k,j)
          sorted=false;
          k=j
    gap=gap/2
        
````

### Analysis

Only an illustration not the calculation of the running time. The worst case is O( $n^2$ ).

### Notes:

#### Why shell sort?

Shell sort is litteraly just another specific version of insertion sort, same logic applies. In fact, in insertion sort we actually have a shell sort with gap=1.
But we do shell because:

the worst case in insertion sort is when the smallest element is at the end of the array; using shell sort, we guarantee that this would not be the worst case: it's a one way of avoiding this from happening.

#### Best case:

Like insertion sort, the best case in shell sort is when all elements are already sorted: O(n)
