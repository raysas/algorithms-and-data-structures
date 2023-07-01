package Sorting;

public class SelectionSort {
	private int[] a;

	public int[] getArray() {
		return a;
	}

	public void setArray(int[] a) {
		this.a = a;
	}
	public SelectionSort(int n)
	{
		a=new int[n];;
	}
	public SelectionSort() {
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
		/*running time O(n2)*/
		int min_index=-1;//1
		for (int i=0;i<a.length-1;i++) 
		{
			/*body runs n-1 times*/
			min_index=i;
			for (int j=i+1;j<a.length;j++)
			{/*body runs n-i times, worst case n-1 times*/
				if (a[min_index]>a[j]) //compares n(n-1)/2 times
					min_index=j;
			}
			exchange(min_index,i);//maximum number of exchanges in n-1
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
		SelectionSort s=new SelectionSort();
		System.out.println(s);
		
	}
	
}
