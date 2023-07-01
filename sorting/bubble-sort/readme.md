## Bubble Sort

### Algorithm

This sorting algorithm is called *bubble* sort because after each iteration and pass of the whole array, the next largest not-in-its-place number *bubbles* its way to the end.
It's probably considered the **easiest** sorting algorithm to implement, however, it's not efficient with a running time of O( $n^2$ ) *(more of that in the [Analysis](#analysis))*.

The algorithm mainly keep passing through the whole array exchanging adjacent arrays that are out of order until the entire array is sorted, following these stepd:
* swap elements at indices 0 and 1 if needed
* swap elements at indices 1 and 2 if needed
* ...
* swap elemets at indices n-2 and n-1 if needed
* **repeat until no swaps is needed**

#### Pseudocode
```
bubble(int[] a, int l, int r)
  swapped:=true
  while swapped
    swapped:=false
    for i:=l-->r-2
      if a[i]>a[i+1]
        swap(i,i+1)
        swapped:=true
```

### Analysis

To understand how we got a running time of O( $n^2$ ) we have to look at  the *number of swaps* and *number of comparisons*

Let's take this particular example:

| 8 | 5 | 3 | 7 | 4 |
|---|---|---|---|---|

PASS 1:

  * check indices 0 and 1: 0 bigger then swap

| 5 | 8 | 3 | 7 | 4 |
|---|---|---|---|---|

  * check indices 1 and 2: 1 bigger the swap

| 5 | 3 | 8 | 7 | 4 |
|---|---|---|---|---|

  * check 2 and 3: swap

| 5 | 3 | 7 | 8 | 4 |
|---|---|---|---|---|

  * check 3 and 4: swap

| 5 | 3 | 7 | 4 | 8 |
|---|---|---|---|---|

so far :

    * biggest element 8 bubbled to the last
    * it took 4 comparisons (n-1)
    * it took 4 swaps (n-1) *(worst case)*
    
PASS 2:

   * check 0 and 1: swap

| 3 | 5 | 7 | 4 | 8 |
|---|---|---|---|---|

   * check 1 and 2: no swaps 

| 3 | 5 | 7 | 4 | 8 |
|---|---|---|---|---|

   * check 2 and 3: swap

| 3 | 5 | 4 | 7 | 8 |
|---|---|---|---|---|

   * check 3 and 4? no swap (always last one no swap)

| 3 | 5 | 4 | 7 | 8 |
|---|---|---|---|---|

so far:
* 2nd biggest element bubbled to 2nd last
* it took 4 comparisons (n-1) 
* it took *a maximum* of 3 swaps (n-2)
    
PASS 3:

* check 0 and 1: no swaps

| 3 | 5 | 4 | 7 | 8 |
|---|---|---|---|---|

* check 1 and 2: swap

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

* check 2 and 3: no swaps

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

* check 3 and 4: no swaps

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

so far:
* 3rd biggest element bubbled to the 3rd last 
* 4 comparisons (n-1)
* maximum of 2 swaps (n-3)

PASS 4:

* check 0 and 1: no change 

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

* check 1 and 2: no change

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

* check 2 and 3: no change

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

* check 3 and 4: no change

| 3 | 4 | 5 | 7 | 8 |
|---|---|---|---|---|

so far:
  * 4th biggest in its place
  * 4 comparisons
  * maximum of 1 swap

**no change in all steps-->sorting terminates**

This example does not clearly illustrate the worst worst case, where we would need to go for another pass, but we can conclude from what we've seen that in the worst case we get n passes.

**Why n passes? aren't n-1 enough for each biggest element to go to its respective place?**
Practically, yes. BUT getting a sorted array does not imply the termination of the program. In other words, if we get back to the example, the array is sorted at the end of pass 3 but yet, we require another to pass for the program to know that it is actually sorted.

i.e., number of passes= n

number of comparisons is: n(n-1) (each pass n-1 compares with n passes maximum)
number of swaps is: (n-1)+ (n-2) + ... + 0 *(the end pass is a 0 swaps pass)* which is the arithmatice series:
$$\sum_{k=1}^{n-1} k = n(n-1)/2$$

hence the running time of O( $n^2$ )

### Notes:

#### Find a reconfiguration of the array when you really need n passes.

TBD. supposedly the array reversed but idk :/

#### Falg 'swapped'

this flag is added to ease out the sorting process, it's not mandatory;
suppose we don't have it, we're gonna necessarily require n passes: running time will still be O( $n^2$ )

