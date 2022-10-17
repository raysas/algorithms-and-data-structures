package lab4;

public class radix {
	
	private static int findMax(int[]a) {
		//this function gets the maximum of the array in order to use it to instanciate the array c later on
		int max=a[0];
		for (int i:a) {
			if (i>max)
				max=i;
		}
		return max;
	}
	
	private static int findMax(int[] a, int d) {
		int digit=(int) Math.pow(10, d-1);
		int max=a[0]/digit%10;
		for (int i:a) {
			int j=i/digit%10;
			if (j>max)
				max=j;
		}
		return max;
	}
	
	public static void printArray(int[] a){
		String s="";
		for (int i:a) {
			s+=i+"\t";
		}
		System.out.println(s);
	}

	public static int[] countingSort(int[] a,int d) {
		//d is the digit number we're working with: 1 for units, 2 for tens, 3 for 100s...
		//always index 0 of a is null
		
		int digit=(int)Math.pow(10,d-1);
		int c_len=findMax(a,d)+1;
		int[] c=new int[c_len];
		//basically create c in which for each index increment if the key of this particular index is found in a
		//for c of size k, creating the array c will take O(k)
		for (int i=1;i<a.length;i++) {
			c[a[i]/digit%10]++;
		}
		//printArray(c);
		//System.out.println("now getting the cumulative frequency distribution :p");
		for (int i=1;i<c_len;i++) {
			c[i]+=c[i-1];
		}
		//printArray(c);
		//now create an array B of the same length of A
		int[] b=new int[a.length];
		for (int i=a.length-1;i>=1;i--) {
			b[c[a[i]/digit%10]]=a[i];
			//System.out.println("c is:");
			//printArray(c);
			//System.out.println("a[i] is:"+a[i]+"\tc[a[i]] is (and will be decremented): "+c[a[i]/digit%10]+"\tb becomes:");
			c[a[i]/digit%10]--;
			//printArray(b);
		}
		//printArray(b);
		return b;
//		System.out.println("both arrays");
//		printArray(b);
//		printArray(a);
	}
	
	public static int[] radix(int[] a) {
		//uses counting sort as a subroutine, still be linear time :/
		//first step is to specify the highest number of digits found:
		int max=findMax(a);
		int max_digits=Integer.toString(max).length();
		for (int j=1;j<=max_digits;j++) {
			printArray(a);
			a=countingSort(a,j);
			printArray(a);
		}
		printArray(a);
		return a;
	}
	
	public static void main(String[] args) {
		int[]a= {0,3,528,27,5,532,3,6,89};
//		countingSort(a,1);
//		countingSort(a,2);
//		countingSort(a,3);
		printArray(a);
		
		a=radix(a);
		printArray(a);
		int[] b= {236,38,5,27,18};
		
		
	}
}
