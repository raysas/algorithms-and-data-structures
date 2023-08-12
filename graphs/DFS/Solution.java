package Ex1;

public class Solution {
	/*
	 * 												Rayane Adam: 202100578
	 * 
	 * implemented using adjacency lists and DFS
	 * 
	 * What should the size of the stack be: V-1
	 * 			the maximum unvisited is when the graph of depth V-1 starting from the root then we have to add V-1 vertices to the stack
	 */
	
	public static void main(String[] args) {
		Graph g=new Graph();
		g.DFS();
		System.out.println("end");
	}
}
