package Sorting;

public class BubbleSort {
	private int[] a;

	public int[] getArray() {
		return a;
	}

	public void setArray(int[] a) {
		this.a = a;
	}
	public BubbleSort(int n)
	{
		a=new int[n];;
	}
	public BubbleSort() {
		//creates an already unsorted array of size n
		a=new int[6];
		int [] b= {9,8,7,6,5};
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
		boolean sorted =false;
		while (!sorted) {
			System.out.println("new pass. original:");
			printArray();
			System.out.println();
			//each iteration is a pass
			sorted=true;
			for (int j=0;j<a.length-1;j++)
			{
				if (a[j+1]<a[j])
				{
					exchange(j, j+1);
					sorted=false;
				}
				printArray();
			}
		}
	}
	public String toString() {
		//prints the sorted array
		String s="";
		sort();//sorts the array 
		System.out.println("end product:");
		for (int i:a)
			s+=Integer.toString(i)+"\t";
		return s;
	}
	
	public void printArray() {
		String s="";
		for (int i:a)
			s+=Integer.toString(i)+"\t";
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		BubbleSort b= new BubbleSort();
		System.out.println(b);
	}
}
