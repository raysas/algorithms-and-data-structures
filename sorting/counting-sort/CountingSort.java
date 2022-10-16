package lab4;

public class CountingSort {

	private int[] A;
	
	public CountingSort() {
		int[] a= {0,4,5,3,2,0,6,3,3,0};
		A=a;
	}
	
	public int findMax() {
		//this method iterates through the array and returns the max element in it
		//#comparisons=n-1
		int max=A[0];
		for(int i=1;i<A.length;i++) {
			if (A[i]>max)
				max=A[i];
		}
		return max;
	}
	
	public int[] sort() {
		int k=findMax()+1;//max element in A
		int[] C=new int[k];
		for (int i=1;i<A.length;i++) {
			C[A[i]]++;
		}
		//now make cumulative C
		for (int i=2;i<C.length;i++) {
			C[i]+=C[i-1];
		}
		//my C is read to use
		int[] B=new int[A.length];
		for (int j=A.length-1;j>=1;j--) {
			B[C[A[j]]]=A[j];
			C[A[j]]--;
		}
		A=B;
		return B;
	}
	
	public String toString() {
		String s="";
		for (int i:A) {
			s+=i+"\t";
		}
		return s.strip();
	}
	
	public static void main(String[] args) {
		CountingSort c=new CountingSort();
		c.sort();
		System.out.println(c);
	}
}
