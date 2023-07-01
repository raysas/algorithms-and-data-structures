## Quicksort

### Algorithm

It's a a divide and conquer algorithm, it's interesting because it's inplace unlike merge sort which saves memory for large sorting problems (O(n) for space). All the work is in the divide step. 

Structure:
n-element array a

divide: 
* pick a pivot element
* partition the array into subarrays L and G

conquer:
* recursively sort subarrays L and G

if less than pivot: move element to left of pivot
if greater than pivot: move element to right of the pivot

#### Basic Quicksort

constantly pivot on either the first entry or the last entry: x=A[1] or A[n]

* partition given x

### Randomized quicksort

x is chosen at random and start partitioning. The expected time is O( $nlogn$ ).

### Paranoid quicksort

Keep on trying to get a balanced partions:
it will check, if it fails tries again.

pseudocode:
```
Repeat:
choose pivot as random element
perform partition
until the it results in: 
card(L)<=3/4 card(A)
card(R)<=3/4 card(a)
```

#### Median finding algorithm

Also a divide and conquer algorithm: applied in linear time.

We need a method that takes an array and a rank x: ***Select(A, i)***
* pick x from the array
* compute k=rank(x)
 * create subarray B of elements or rank<rank(x) (size k-1)
 * create subarray C of elements of rank>ran(x) (size n-k)

and recurse on B and C:
```
if (k==i)
  return x
else if(k<i)
  return Select(B, i)
else
  return Select(C, i-k) 
```

BUT a bad selection woulf take O( $n^2$ ) which just took all our efforts of getting median in linear time insted of nlogn. Sooooooooo we have to know how to pick x.

Arrange the array into solumns of 5 (2D-array, 5th column might be not full)
sort each column: big elements onn top (linear time: 5 elements duh...)
find **the median of medians**.

how many elements are guaranteed to be >x: half of the n/5 group 
uhhh i'm lost

|   B   | x |   C   |
|-------|---|-------|


### Analysis

#### Basic Quicksort

It has a worst case of O( $n^2$ ) when array is sorted/ reverse sorted (depending whther pivot is 1st or last)
so we'll get an array with n-1 elements and another with 0 elements.

T(n)=T(n-1)+ n (the n is from the divide?)
T(n)=O(n $^2$ )

but in most cases, this doesn't happen. To avoid it:
randomize the pivot 

on average case it takes O( $nlogn$ )

### Paranoid Quicksort

**Best case:** L and G are exactly n/2 in size

a bad call would be when either L or G is less than 1/4: probability of a good call is $>=$ 0.5. This probability shows that the expected number of iterations is 2.

$T(n)=T(3n/4)+T(n/4)+n$
Overall it takes O($nlogn$)

I don't think it's possible to do in iterative method :/

### Notes

#### Pivot Selection

how to select a pivot that will guarantee a worst case of O( $nlogn$ ):

[median-finding algorithm](#median-finding-algorithm)

the recurrence becomes: T(n)= 2T( $n/2$ )+n  + n
