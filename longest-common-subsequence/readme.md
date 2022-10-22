# Longest Common Subsequence Problem (LCS)

Given 2 sequences X and Y, find the largest possible subsequence that is common in both; *note that we can eliminate characters in the middle*.
This problem is especially useful for **bioinformatics applications** where *X and Y are DNA sequences of 2 organisms* and finding the LCS alows us to know how closely related they are.

*For simplicity, we'll use **binary sequences** in this version of the problem.*

## Brute Force

One intuitive solution for this problem is to **try every single pssibility** by checking all possible subsequences. 
Check every subsequence in X if it's present in Y. For m idices in X, there exist 2^m^ different subsequences of X, requiring *exponenetial time* $O(2^m)$ to solve this problem 

## Dynamic Programming

DP is a recursive **optimization** procedure which optimizes step-by-step using info from the preceding steps and optimizing as we go.
An **optimization problem** is a problem that have an ***objective function*** to ***maximize*** or ***minimize***.

This problem can be solved with dynamic programming: it's a maximization problem that has as objective function finding a subsequence. 

### Building Z: optimized subsequence

*X<sub>i</sub>=x<sub>1</sub>x<sub>2</sub> ... x<sub>i</sub>*

*Y<sub>j</sub>=y<sub>1</sub>y<sub>2</sub> ... y<sub>y</sub>*

*Z=z<sub>1</sub>z<sub>2</sub> ... z<sub>k</sub>*

building Z step-by-step using these inferences:

* if x<sub>i</sub>=y<sub>j</sub> : 
  * `len(LCS(Xi, Yj)) = 1 + len(LCS(Xi-1, Yj-1)` 
  * include character in Z (z<sub>k</sub>=x<sub>i</sub>=y<sub>j</sub>)
* if x<sub>i</sub> $\neq$ y<sub>j</sub> AND z<sub>k</sub> $\neq$ x<sub>i</sub> : 
  * `len(LCS(Xi, Yj)) = len(LCS(Xi-1, Yj)` 
* if x<sub>i</sub> $\neq$ y<sub>j</sub> AND z<sub>k</sub> $\neq$ y<sub>j</sub> : 
  * `len(LCS(Xi, Yj)) = len(LCS(Xi, Yj-1)`

we can prove it by contradiction
