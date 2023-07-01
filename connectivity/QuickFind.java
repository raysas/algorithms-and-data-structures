package Connectivity;

public class QuickFind {
	/*
	 * In this exercise the elements of the array are instantiated to each respective index
	 * to find a connection, check whether the 2 elements have the same value
	 * to establish a connection, make the value of all elements who are connected to one equal to the value of the other
	 */
	
	public static boolean find(int[] a,int p,int q) {
		//returns whether p and q are connected: O(1)
		return a[p]==a[q];
	}
	public static void union(int[] a,int p, int q) {
		//connects p and q by changing all elements of a that have are connected to p to be connected to q: O(n)
		for (int i=0;i<a.length;i++) {
			if (a[i]==a[p]) {
				a[i]=a[q];
			}
		}
	}
	
	

}
