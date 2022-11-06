# DYNAMIC PROGRAMMING

*series of problems in class/lab/assignments/book... that require DP in order to solve in polynomial time*

## Edit Distance

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

## Longest Increasing Subsequence 

[LIS](./LIS.java): assignment problem that took me a week to think of :p 

**Given a sequence of real numbers, use dynamic programming to find the**
**longest increasing subsequence in which the values form a strictly increasing**
**sequence. The values do not have to be consecutive.**

*e.g. input:*
| 1 |10 | 5 | 2 | 17 | 8 | 9 | 11 |
|---|---|---|---|---|---|---|---|

output:
| 1 | 2 | 8 | 9 | 11 |
|---|---|---|---|---|
