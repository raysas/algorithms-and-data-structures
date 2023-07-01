package Sorting;

public class MergeSort {

	public static int[] merge(int[] a, int[] b)
	{
		//takes 2 sorted arrays and merges them together in a sorted way
		int i=0;
		int j=0;
		int [] c=new int[a.length+b.length];
		for (int k=0;k<c.length;k++)
		{
			if ( (j>=b.length) || (i<a.length && a[i]<b[j] )  )
			{
				c[k]=a[i];
				i++;
			}
			else {
				c[k]=b[j];
				j++;
			}
		}
		return c;
	}
	
	public static int[] sort(int[] a, int r, int l) {
		if (r>=l) //base case T(1)=1
		{
			int [] t=new int[1];
			t[0]=a[r];
			return t;
		}
		int mid=(r+l)/2;
		int [] b=sort(a,r, mid);
		int[] c=sort(a,mid+1,l);
		return merge(b,c);
	}
	
	public static int[] sort(int[] a) {
		//default
		return sort(a,0,a.length-1);
	}
	
	public static void printArray(int [] a) {
		String s="";
		for (int e: a) {
			s+=e+"\t";
		}
		System.out.println(s);
	}
	public static void main(String[] args) {
		int [] a= {1,4,7,30};
		int [] b= {2,8,13,66};
		int [] c=merge(a,b);
		int [] d= {22,57,9,1,5,9};
		printArray(sort(d));
	}
}
