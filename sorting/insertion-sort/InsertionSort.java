package Sorting;

public class InsertionSort {
	private int[] a;

	public int[] getArray() {
		return a;
	}

	public void setArray(int[] a) {
		this.a = a;
	}
	public InsertionSort(int n)
	{
		a=new int[n];;
	}
	public InsertionSort() {
		//creates an already unsorted array of size n
		a=new int[10];
		int [] b= {6,2,8,5,1,7,11,3,9,4};
		a=b;
	}
	
	public void exchange(int i,int j) {
		/*swaps values of index i and j in the array, returns nothing
		 * runs in O(1)
		 */
		int temp=a[i];	//1
		a[i]=a[j];		//1
		a[j]=temp;		//1
	}
	
	public void sort() {
		int key;boolean sorted=false;
		for (int i=1;i<a.length;i++)
		{
			//starts at index 1 sets its item as key
			key=a[i];
			for (int j=i-1;j>=0 && !sorted;j--)
			{
				printArray(a);
				
				if (key<a[j]) {
					exchange(j+1,j);
				}
				else sorted=true;
			}
			sorted=false;
		}
		
	}
	public String toString() {
		//prints the sorted array
		String s="";
		sort();//sorts the array 
		for (int i:a)
			s+=Integer.toString(i)+"\t";
		return s;
	}
	
	public void printSorted() {
		System.out.println("before sorting:\t"+toString());
		sort();
		System.out.println("after sorting:\t"+toString());
	}
	
	public static void main(String[] args) {
		InsertionSort i=new InsertionSort();
		System.out.println(i);
	}
}
