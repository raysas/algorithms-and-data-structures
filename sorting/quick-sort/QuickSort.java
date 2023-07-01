package Ex3;
/*
 * 							________________________________
 * 									Rayane Adam
 * 									202100578
 * 									CP3 assignment 2 exercise 3
 * 									Quicksort :D
 * 									Last modified: 10/6/2022 12:08AM
 * 							________________________________
 * 
 * Quicksort in place algorithm: 
 * 		-pivot is the first element
 * 		-the first element is constantly being swapped by a random element of the current sub-array before any swapping attempt
 * 		-hope it runs for you in O(nlogn) :D
 * 								
 */

public class QuickSort {

	private int[] a;
	
	public QuickSort(int n) {
		a=new int[n];
	}
	public QuickSort() {
		int[] b= {4,6,5,3,1,7,8,2};
		a=b;
	}
	public QuickSort(int[] b) {
		a=b;
	}
	
	public void printArray() {
		String s="";
		for (int i:a) {
			s+=i+"\t";
		}
		System.out.println(s.strip());
	}

	public int[] getA() {
		return a;
	}

	public void setA(int[] a) {
		this.a = a;
	}
	
	public void swap(int i,int j) {
		//swaps elements at indices i and j
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	public static int generateRandom(int min, int max) {
		return (int) (Math.random()*(max+1-min)+min);
	}
	
	private void sort(int i, int j) {
		//helper method
		System.out.println("\n\t----------------------\n");
		System.out.println("starting array:");
		printArray();
		int start=i;
		int end=j;//saves the start and end for recursive calls
		if (start>=end) {
			if (i<a.length)System.out.println(a[i]+" in sorted place; no change");
			else if (j>0) System.out.println(a[j]+" in sorted place; no change");
			return;
		}
		System.out.println("start:"+start+"\tend:"+end);
		int p=i;//p starts in the first element
		int random=generateRandom(start,end);
		System.out.println("randomization of pivot by swapping "+a[p]+" by "+a[random]+"; array after randomization:");
		swap(p,random);
		printArray();
		int pivot=a[p];
		System.out.println("starting with the pivot "+pivot+" in the first index "+p);
		//System.out.println(start);
		while (j>=i) {
			if (a[j]<a[p]) {
				if (a[i]>a[p])
					swap(i,j);
				else i++;
			}
			else j--;
		}
		//System.out.println(a[p]<a[j]);
		if (j>start &&a[p]>a[j]) {
			swap(p,j);
			p=j;
		}
		System.out.println("sorting, hang on :/ ... done! :p");
		System.out.println("the pivot "+a[p]+" in its sorted place at index "+p+" in the array:");
		printArray();
		//System.out.println(start);
		sort(start,p-1);
		sort(p+1,end);
	}
	
	public void sort() {
		sort(0,a.length-1);
	}
	
	
	public static void main(String[] args)
	{
		QuickSort q=new QuickSort();
		//System.out.println(generateRandom(0,1));
		q.sort();
	}
}
