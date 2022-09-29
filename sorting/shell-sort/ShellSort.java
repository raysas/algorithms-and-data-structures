package Sorting;

public class ShellSort {
	
	private int[] a;

	public int[] getArray() {
		return a;
	}

	public void setArray(int[] a) {
		this.a = a;
	}
	public ShellSort(int n)
	{
		a=new int[n];;
	}
	public ShellSort() {
		//creates an already unsorted array of size n
		a=new int[6];
		int [] b= {35,33,42,10,14,19,27,44};
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
	public void sort() {
		boolean sorted=false;
		int gap=a.length/2;
		while (gap>=1 && !sorted) {
			sorted=true;
			System.out.println("gap="+gap);
			System.out.println("original:");
			printArray();
			for (int i=gap;i<a.length;i++)
			{
				System.out.println("new iteration:");
				int k=i;
				for (int j=i-gap;j>=0;j=j-gap) {
					if (a[j]>a[k])
					{
						exchange(j,k);
						k=j;
						sorted=false;
					}
					printArray();
				}
			}
			System.out.println("end of this interval sort");
			printArray();
			gap=gap/2;
			
		}
	}
	
	public static void main(String[] args) {
		ShellSort s=new ShellSort();
		System.out.println(s);
	}

}
