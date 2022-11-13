# DYNAMIC PROGRAMMING

## Algorithms

*series of problems in class/lab/assignments/book... that require DP in order to solve in polynomial time*

some algorithms are directly explained in the comments in java files because i'm too lazy to write them here :/

### Edit Distance

[Edit Distance](./EditDistance.java): from assignment, this problem has many versions where the conditions are shuffled

**Given two words, the edit distance between them is the minimum number
of modifications that must be performed in order to change one into the other. the
possible modifications are :**
* insert a letter
* remove a letter
* substitute a letter with
another.

*e.g., we want to go from ***hello*** to ***ellen***:*
the minimum amout of operations needed is 3
* dellete h (hello-->ello)
* replace o by e (ello-->elle)
* add n (elle-->ellen)

*this algorithm is especially useful for auto-correction*

### Max Rectangle

[Maximal Rectangle](./MaxRectangle.java): really neat.

Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

| 1 | 1 | 1 | 1 | 0 | 1 |
|---|---|---|---|---|---|
| 1 | 1 | 1 | 0 | 0 | 1 |
| 1 | 1 | 1 | 0 | 1 | 1 |
| 1 | 1 | 1 | 1 | 1 | 1 |


here the max rectangle is left 4x3 so the program must return 12

### Max Square

[Maximal Square](./MaxSquare.java): from lab; same even simpler algorithm than the rectangle one. I solved this one before it

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

### Maximum Product Subarray

[Max Product Subarray](MaxProductSubarray.java): leetcode

Given an integer array nums, find a subarray that has the largest product, and return the product.

*e.g. input:*
| 2 | 3 | -2 | 4 |
|---|---|---|---|

output: the product is 6, the subarray would be
| 2 | 3 |
|---|---|

### Longest Increasing Subsequence 

[Longest Increasing Subsequence](./LIS.java): assignment problem that took me a week to think of :p 

**Given a sequence of real numbers, use dynamic programming to find the**
**longest increasing subsequence in which the values form a strictly increasing**
**sequence. The values do not have to be consecutive.**

*e.g. input:*
| 1 |10 | 5 | 2 | 17 | 8 | 9 | 11 |
|---|---|---|---|---|---|---|---|

output:
| 1 | 2 | 8 | 9 | 11 |
|---|---|---|---|---|

### Largest Sum Contiguous Subarray (Kadane’s Algorithm)

[Largest Sum Contiguous Subarray](./LSCS.java): a better implementation would be using a 1-d array, also assignment :p 

**Given a one-dimensional array of integers, use dynamic programming to
find the contiguous subarray within this array of numbers which has the largest sum.**

*e.g., input:*
| -2 | 1 | -3 | 4 | -1 | 2 | 1 | -5 | 4 |
|---|---|---|---|---|---|---|---|---|

output: (sum=6)
| 4 | -1 | 2 | 1 |
|---|---|---|---|
