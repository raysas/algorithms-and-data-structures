## Merge Sort

### Algorithm

Merge sort is a Divide and Conquer sorting algorithim that works on dividing the arrays into subarrays progressively until we reach an array of one element (sorted), and merge in a sorted fashion.

### Analysis

### Notes

#### All cases: O( $logn$ )

Best case, worst case, average case, merge sort is always running in O( $logn$ ), making it the fastest possible sorting algorithm. Quick sort also runs in the same complexity, however its worst case can sometimes get to O( $n^2$ ) as discussed in the [quick sort analysis]()

#### Why use quicksort if there's merge?

Space is as important as time! merge sort is not an inplace sorting algorithm unlike quicksort, which can be both.
