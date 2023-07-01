## Heap Sort

### Algorithm

This sorting algorithm requires a Data Structure called a [Heap](#data-structures:-heaps)

### Analysis

### Data Structure: Heaps

#### Priority Queue

It's a structure that implements a set S of elements and each of these elements is associated with a key. *This part is from CLRS*

Operations:
* insert(S, x): insert element x into the set S
* max(S): returns the max of S
* extractMax(S): returns the max of S and removes it from S (like pop)
* increaseKey(S, x, k): increase the value of x's key to the new value k 
* buildMaxHeap: produce a max heap from an arbitrary unordered array
  * convert the array into a max heap
  * observation: a\[n/2 +1... n] are all leaves
  * complexity: O ( $n log n$ ) in simple analysis. Can I do better?

  Yes. Order n 

  * pseudocode:
  ```
  buildMaxHeap(int[] a):
    n=a.length
    for i:=n/2 -->1
      maxHeapify(a,i)
  ```
* maxHeapify: correct a single violation of the max heap property in a subtree's root (we need to do this recursively to build a max heap).
  * what it really does is exchange the root with the child that introduced the violation
  * proceeds recursively
  * complexity:
      The height of the tree is log n. Complexity would be O(nlogn) however can be proved to be in fact linear
      
  * pseudocode:
    ```
    maxHeapify(int[] a, int i):
      
    ```

#### Heap
an implementation of a priority queue

It's an array visualized as a nearly complete binary tree


|   |   |   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|---|---|

#### Heap as a tree

* root of the treee: the first element
* parent(i): i/2
* left(i)= 2i
* right(i)=2i+1

#### Properties

* Max Heap Property: The key of the node $ >= $ the keys of its children
* Min Heap Property: The key of the node $ <= $ the keys of its children
