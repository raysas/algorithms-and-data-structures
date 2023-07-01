public class LIS{
  public class Problem {
	/*
	 * 	--------------------------------------------------------------------------------------------------------
	 * 							Rayane Adam
	 * 							202100578
	 * 							CP3- ASSIGNMENT 3
	 * 						DYNAMIC PROGRAMMING: LONGEST INCREASING SUBSEQUENCE (LIS)
	 * 							Last modified: 6:58PM 11/5/2022
	 * 						
	 * ALGORITHM:
	 * 		- this algorithm memoize using a 1-d array 
	 * 		- similar to rod cutting, it has the max function between a list of previous items
	 * formula:
	 * 				1 if i=0
	 * 		t[i]= 
	 * 				max(a[k])+1 for i-1<=k<=0 if a[k]<a[k-1]
	 * 					1 	if for all i-1<=k<=0 a[k]>a[k-1]
	 * t[i]=the length of the LIS of a[0:i+1]
	 * 
	 * BACKTRACKING:
	 * also in this problem i coul've go for parent pointer but there's an interesting pattern in pointers
	 * 	it can be logically inferred that:
	 * - in the memoized array, if t[i]=t[i-1]+1 we can conclude that index i-1 is the parent of i in a
	 * 		(because increment by one happened, thus obeyed the condition in formula, thus counted in the lis)
	 * we start by the last index, that has the the length of our desired LIS, we start looking for the parent
	 * NOTE: when we find the first parent we append it and its child to the LIS (can be seen clearly in the code)
	 * -------------------------------------------------------------------------------------------------------------
	 */

	private int[] a;
	
	public LIS() {
		//uses the example in the assignment by default
		int[] b={1,10, 5, 2, 17, 8, 9, 11};
		a=b;
	}
	public LIS(int[] b) {
		a=b;
	}
	
	private void printArray(int[] b) {
		String s="";
		for (int i:b) {
			s+=i+"\t";
		}
		System.out.println(s);
	}
	
	private int[] getArray() {
		//returns the array that i will backtrack from
		int[] t=new int[a.length];
		t[0]=1;
		for (int i=1;i<a.length;i++) {
			if(a[i]>a[i-1]) {
				t[i]=t[i-1]+1;
			}
			else {
				int k=i-1;
				while(k>=0 && a[k]>a[i])
					k--;
				if (k<0)
					t[i]=1;
				else t[i]=t[k]+1;
			}
		}
		return t;
	}
	
	private int[] backtrack(int[] b) {
		//b is the result of getArray()
		int[] temp=new int[b.length];//longest increassing subsequence will be the exact array of the same length
		int count=0;
		for (int i=b.length-1;i>0&&b[i]>=b[i-1];i--) {
			if (b[i]==b[i-1]+1) {
				if (count==0) {
					//here a[i] is the greatest item that should be inluded in the LIS so i don't just append its parent, append it too
					temp[count]=a[i];count++;
				}
				temp[count]=a[i-1];
				count++;
			}
		}
		int[] my_lis=new int[count];
//		System.out.println(count);
		for (int k=count;k>0;k--) {
			my_lis[count-k]=temp[k-1];
		}
		return my_lis;
	}
	
	public void solve() {
		int[] table=getArray();
		int[] lis=backtrack(table);
		System.out.println("the orginal array:");
		printArray(a);
		System.out.println("\n\t\tthe table:");
		printArray(table);
		System.out.println("\n\tthe longest increasing subsequence:");
		printArray(lis);
	}
	
	public static void main(String [] args) {
		int[] b={-2,1,-3,4,-1};
		LIS p=new LIS ();
		p.solve();
	}

}
