package find_union;

import java.util.Scanner;

public class Problem {
	//THE CONNECTIVITY PROBLEM
	
	/*
	 * a 2 int p and q are connected (p-q) if they are in an equivalence relation:
	 * 		-reflexive
	 * 		-symmetric
	 * 		-transitive
	 * in this problem we have a set of numbers
	 * input: p q
	 * output: checks if p and q are connected
	 * 		-true: doesn't do anything
	 * 		-false: establish a connection
	 * for an easier track, after each input, it'll print the connections
	 */
	
	public static void main(String[] args) {
		QuickFind p=new QuickFind();
		
		if (p.find(2, 4))
			System.out.println("stays the sam\n"+p.getId());
		else
		{
			p.union(2, 4);
			System.out.println("connection extablished\n"+p.getId());
		}
	}
}
