package Sorting;

public class HeapSort {
	//heapsort uses heap as a data structure
	//a heap is a binary tree that is an implementation of a priority queue
	//practically it's a max heap

	private int[] heap;//0 and -1 are sentinel values 
	private int n;//keeps count of the number of nodes in the heap
	
	public HeapSort() {
		heap=new int[8];
		n=0;
		//index 0 will always be empty
	}
	
	public HeapSort(int[] a) {
		heap=a;//given that a has no empty elements and index 0 is 0
		n=a.length-1;
	}
	
	public void printHeap() {
		String s="";
		for (int i:heap) {
			s+=i+"\t";
		}
		System.out.println(s);
	}
	
	private int parent(int i) {
		if (i==1) return 1;
		return i/2;
	}
	
	private int left(int i) {
		return 2*i;
	}
	
	private int right(int i) {
		return 2*i+1;
	}
	
	private int getParent(int i) {//O(1)
		//if i is root, returns itself
		if (i==1) return heap[i];
		return heap[i/2];
	}
	
	private int getLeft(int i) {//O(1)
		//if i is a leaf or has no left children returns -1 as a sentinel value
		if(2*i>n)return -1;
		return heap[2*i];
	}
	private int getRight(int i) {//O(1)
		//if i is leaf or no right child -->returns -1
		if(2*i+1>n) return -1;
		return heap[2*i+1];
	}
	
	private void ensureCapacity() {
		//runs in O(n)
		//note that the size of the array is always a power of 2 :p
		int[] new_heap=new int[heap.length*2];
		for(int i=0;i<heap.length;i++)
		{
			new_heap[i]=heap[i];
			//copying all old elements of the heap in the new array
		}
		heap=new_heap;
	}
	
	private void swap(int i, int j) {//O(1)
		int temp=heap[i];
		heap[i]=heap[j];
		heap[j]=temp;
	}
	
	public void swim(int k) {//O(log n)
		//restores the value of a heap data structure by forcing the node at index k to be smaller than its parent
		int temp=k;
		while(heap[temp]>getParent(temp) && temp>1 )
		{
			swap(temp,temp/2);
			temp=temp/2;
		}
	}
	
	public void insert(int i) {//O(log n)
		//inserts element at the end of the array then swims it to its correct place
		if (n==heap.length) ensureCapacity();
		n++;
		heap[n]=i;
		swim(n);
	}
	
	private boolean isLeaf(int i) {
		boolean no_right=(2*i+1)>n;
		boolean no_left=(2*i)>n;
		return no_right && no_left;
	}
	
	private boolean hasLeft(int i) {
		return !(2*i>n);
	}
	private boolean hasRight(int i) {
		return !(2*i+1>n);
	}
	
	public void sinkRec(int i) {
		//lets the element at index i floats down to its place
		if(isLeaf(i)) return ;
		int max;
		if (hasRight(i) && hasLeft(i))
		{
			int r=right(i);
			int l=left(i);
			if (heap[r]>heap[l]) max=r;
			else max=l;
		}
		else if(hasRight(i)) max=right(i);
		else max=left(i);
		//now that i got my max child i compare it to my node
		if (heap[max]>heap[i])
		{
			swap(max,i);
			System.out.println(heap[max]);
			sinkRec(max);//max is the index now of the smaller parent that was swapped with its largest child
		}
	}
	
	public int max(int i) {
		if(isLeaf(i)) return -1;
		if (hasRight(i) && hasLeft(i))
		{
			int r=right(i);
			int l=left(i);
			if (heap[r]>heap[l]) return r;
			else return l;
		}
		else if(hasRight(i)) return right(i);
		else  return left(i);
	}
	
	public void sinkItt(int i) {
		int max=max(i);
		System.out.printf("sinking %d\n",heap[i]);
		while (max!=-1 && heap[max]>heap[i]) {
			swap(i,max);
			//my element now is at index max
			i=max;
			max=max(i);
		}
	}
	
	public void buildMaxHeap() {
		for (int i=n/2;i>0;i--)
		{
			sinkItt(i);
			//sink every internal node
		}
	}
	
	public void deleteMax() {
		swap(1,n);
		printHeap();
		System.out.printf("swapped %d with %d done successfully, %d is fixed outside heap \n",heap[1],heap[n],heap[n]);
		n--;//extract max to the last element then reduce the counter as if it's not part of the heap anymore
		sinkItt(1);
		System.out.printf("number of elements left:%d\n",n);
	}
	
	
	public void sort() {
		System.out.println("building max heap...");
		buildMaxHeap();
		System.out.println("my max heap:");
		printHeap();
		System.out.println("\t-------------------\n");
		int size=n;
		for (int i=0;i<=size-1;i++) {
			System.out.printf("trial %d: \n",i+1);
			printHeap();
			System.out.printf("max is %d, swap with %d \n",heap[1],heap[n]);
			swap(1,n);
			n--;
			sinkItt(1);
			System.out.println("becomes:");
			printHeap();
			System.out.println("\t----------------\n");
		}
	}
	
	public static void main(String[] args) {
		int[] a= {0,3,7,2,5,1,6,4};
		HeapSort h=new HeapSort(a);
		h.printHeap();
		h.sort();
		h.printHeap();
	}
}
