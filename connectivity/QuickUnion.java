package Connectivity;

public class QuickUnion {
	/*
	 * In this exercise the elements of the array are instantiated to each respective index
	 * At the beginning they're all defined as the root of the tree
	 * a root has a value that matches its index
	 * to find a connection, check whether the 2 elements have the same root
	 * to establish a connection, make the root if one a child of the root of the other
	 */
	
	public static int root (int[] a,int i) {
		//returns the root of an item: O(n)
		while (a[i]!=i) {
			i=a[i];
		}
		return i;
	}

	public static boolean find(int[] a,int[] size,int p,int q) {
		//returns if p and q have the same root: O(depth of the tree)
		return root(a,p)==root(a,q);
	}
	
	public static void union(int[] a,int p, int q) {
		//make root of q the child of the root of p: O(depth of the tree)
		int r=root(a,p);
		int s=root(a,p);
		a[s]=a[p];
	}
}
