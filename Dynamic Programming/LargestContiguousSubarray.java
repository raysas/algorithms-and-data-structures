public class LargestContiguousSubarray{
  /*
 * --------------------------------------------------------------------------------------------
 * 
 * 										Rayane Adam
 * 										202100578
 * 										CP3- ASSIGNMENT 3
 * 										DYNAMIC PROGRAMMING: Largest Sum Contiguous Subarray
 * 										Last modified: 10:29PM 10/30/2022
 * p.s. if i manage to do this whole DP assignment thing correctly i'm buying everyone candies 
 * 
 * ALGORITHM:
 * 
 * 	-the formula:
 * 						0 if i==0 or j==0
 * 			t[i][j]=	
 * 						max(t[i-1][j-1]+a[j],t[i-1][j]) if i!=0 and j!=0
 * 
 * rows(i): first row 0s
 * 			meaning: the # of elements inside the sub-array
 * 			i=1: 1 item in the contiguous array
 * 			so on and so forth
 * columns(j):
 * 			meaning: each item of the array included in the previous sub-array of greatest sum
 * 			j=0 corresponds to the 1st item in the array a[0] as the only element of the subarray
 * 			j=c corresponds to the items from a[0] to a[c] where a[c] is included in the cont. sub-array of highest sum
 * 
 * a[i][j]= greatest sum of a sub-array inside the array of i elements with j being the last item of this subarray
 * 
 * 
 * this formula is edited a bit in the implementation process for technical reasons:
 * 		- the first row is initialized to 0	to fit the formula and add the values diagonally
 * 			(this initialization is necessary to add the value to 0, in case of a negative int it will consider it smaller than 0 then won't do the addition for the 2nd row)
 * 		- the first column is initialized to the 1st value of the array (having the 1st value of the array included as the only item in this sub-array)
 * 			(this initialization is necessary not to get a negative index when calling the formula on [j-1]
 * 
 * the backtracking part is tricky: (used logical backtracking instead of physically saving pointers)
 * 		at the end of the memoization (filling the matrix), in the last row, the maximum is the max sum
 * 		so start backtracking from the maximum element (get its index in O(n) :p)
 * 		each time we traverse diagonally we save the array element at this index j in a temp array as it is a part of our sub-array
 * 		we keep on going diagonally until we hit one of the following:
 * 			-i<1 (<1 item in the sub array=> empty)
 * 			-j<0 (we backtracked to the first element of the array can not go back more)
 * 			-t[i-1][j-1]<0 THE MOST IMPORTANT PART OF THE BACKTRACKING
 * since adding values diagonally mean 
 * 		"I want the best sub-array of i items to be the best sub-array for i-1 items +the item at j"
 * then whenever i'm going back, this addition must not decrease my sum=> hence it should not be negative
 * 							BOOM
 * it's either really smart or really dumb :')
 * 
 * --------------------------------------------------------------------------------------------
 */
	
	public static void main(String[] args) {

		int[] A={-2,-3,4,-1,-2,1,5,-3};
		Problem p=new Problem(A);
		int[] b=p.getSubArray();
		
	}
}


class Problem {
	
	private int[] a;
	
	public Problem() {
		int[] b={-2, 1, -3, 4, -1, 2, 1, -5, 4};
		//example in assignment
		a=b;
	}
	public Problem(int[] b) {
		a=b;
	}
	
	private void printArr(int[] b) {
		//prints the array
		String s="\n";
		for (int i=0;i<b.length;i++) {
			s+=b[i]+"\t";
		}
		System.out.println(s);
	}
	
	private void printMatrix(int[][] m) {
		//prints the matrix
		String s="";
		for (int i=0;i<m.length;i++) {
			for (int j=0;j<m[0].length;j++)
				s+=m[i][j]+"\t";
			s+="\n";
		}
		System.out.println(s);
	}
	
	private int getMax(int a,int b) {
		//returns max between 2 ints
		if (a>=b) return a;
		return b;
	}
	
	private int MaxArr(int [] b) {
		//returns the index of the max elements in an array O(n)
		//returns index of max element
		int max=b[0];
		int max_index=0;
		for (int i=1;i<b.length;i++) {
			if (b[i]>=max) {
				max=b[i];
				max_index=i;
			}
		}
		return max_index;
	}

	private int[][] getMatrix() {
		int m=a.length;
		int[][] matrix=new int[m+1][m];
		//rows are m+1 because first row initialized to 0
		for (int i=0;i<m+1;i++) {
			for (int j=0;j<m;j++) {
				if (i==0)
					//initialize the first row to 0
					matrix[i][j]=0;
				else if(j==0)
					//initialize the first column to the 1st element in our array
					matrix[i][j]=a[0];
				else if (i==1)
					//each element in the 2nd row is equal to its respective element in a (j) 
					//(sum when there's one item and this item is the one at index j)
					matrix[i][j]=a[j];
				else {
					//the ✨almighty formula✨:
					matrix[i][j]=getMax(matrix[i-1][j-1]+a[j],matrix[i-1][j]);
				}
			}
		}
		System.out.println("matrix for tracking:\n");
		printMatrix(matrix);
		System.out.printf("the max sum of the continuous sub-array is %d\n",MaxArr(matrix[m]));
		return matrix;
		
	}
	
	public int[] getSubArray() {
		//backtracking
		int[][] m=getMatrix();
		int last_element_index=MaxArr(m[m.length-1]);
		//since we got the index of the last element (in the original array a) we know that the sub array is of max length this index+1
		int[] sub=new int[last_element_index+1];
		
		int i=m.length-1;int j=last_element_index;//m[i][j] is initialized to the cell with the largest sum
		System.out.println(m[i-1][j-1]);
		int count=1;
		sub[0]=a[j];
		while(i>0 && j>=0 && m[i-1][j-1]>=0) 
		{
			//if previous cell is negative (it represents largest sum of the previous contiguous sub-array 
			//=> will decrease the sum, not included
			i--;j--;
			sub[count]=a[j];
			count++;
		}
		int[] my_sub=new int[count];
		for (int k=0;k<count;k++) {
			my_sub[k]=sub[count-1-k];
		}
		System.out.print("\noriginal array: ");
		printArr(a);
		System.out.print("The contiguous subarray within this array which has the largest sum:");
		printArr(my_sub);
		return my_sub;
	}
	
}
	
