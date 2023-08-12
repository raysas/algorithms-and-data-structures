package Ex1;

public class Kruskal {
	
	/*
	 * Rayane Adam
	 * 202100578
	 * CP3- Assignment 5
	 * -----------------
	 * KRUSKAL'S ALGO:
	 * -----------------
	 * in this program the graph is directly instantiated and we're using an array of edges implementation, 
	 * no add vertex/add vertex: the focus is on the algorithm
	 * 
	 * 2 main objectives in implementation:
	 * 	- sorting the edges: will use merge sort (O(eloge))
	 * 	- checking if adding an edge will create a cycle: will use quick find (find O(1), union O(v))
	 * 
	 */
	
	private int[] v;
	private int[][] e;
	private int[] connected;
	
	public Kruskal() {
		/*undirected graph, can be represented in adj list as the following:
		 * 0: 1->2
		 * 1: 0->3->5
		 * 2: 0->3->4
		 * 3: 1->2->4->5
		 * 4: 2->3->5
		 * 5: 1->3->4
		 */
		int[]a= {0,1,2,3,4,5};
		int[][] b= {{0,1,2},{0,2,4},{1,3,7},{1,5,5},{2,3,6},{2,4,3},{4,5,8},{3,4,1},{3,5,9}};
		v=a;e=b;
		connected=new int[a.length];
		for (int i=0;i<a.length;i++) {
			connected[i]=a[i];
		}
	}
	
	
	private int[][] merge(int[][] a,int[][] b){
		int[][] c=new int[a.length+b.length][3];
		int i=0;int j=0;int k=0;
		while (i<a.length && j<b.length) {
			if (a[i][2]>b[i][2]) {
				c[k]=a[i];
				i++;k++;
			}
			else {
				c[k]=b[j];
				j++;k++;
			}
		}
		while (i<a.length) {
			c[k]=a[i];i++;k++;
		}
		while (j<b.length) {
			c[k]=b[j];j++;k++;
		}
		return c;
	}
	
	private int[][] sort(int[][] i,int l,int r){
		//O(ElogE)
		
		if (l<0||r>=i.length) return null;
		if (l==r) {
			int [][] t=new int[1][3];
			t[0]=i[l];
			return t;
		}

		int m=(r+l)/2;
		return merge(sort(i,l,m),sort(i,m+1,r));
	}
	
	public int[][] sort(){
		//sort edges using merge sort based on weights
		return sort(e,0,e.length-1);
	}
	
	private boolean find(int p,int q) {
		if (connected[p]==connected[q])
			return true;
		return false;
	}
	private void union(int p,int q) {
		int a=connected[p];
		for (int i=0;i<connected.length ;i++) {
			if (connected[i]==a)
				connected[i]=connected[q];	
		}
	}
	
	public boolean connect(int p,int q) {
		//returns true if already connected, false otherwise and connects them
		if (find(p,q)) return true;
		union(p,q);
		return false;
	}
	
	

	
	public int[][] createMST(){
		//returns the edges in the MST
		int[][] mst=new int[v.length-1][3];//V-1 edges in MST
		int c=0;
		int[][] sorted_edges=sort();//takes O(ElogE)
		for (int[] edge: sorted_edges) {
			
			//repeating E times:

			if (!connect(edge[0],edge[1])) {
				
				//connect()'s union takes O(V) if not connected (V-1 times done) and the rest O(1) (since we only do find for those)
				
				mst[c]=edge;
				c++;
			}
			//if the vertices in this edge already connected: don't add edge
		}
		//this E iteartions are divided to V-1 times O(V) (union) and E-(V-1) takes O(1), so worst case O(V^2)+O(E)=O(V^2)
		//(and practically the worst case where E=V-1 it will take O(V^2)+0 but we're summing both worst cases and we're getting the same result anyway)
		return mst;
		//in total O(ElogE+V^2)
	}
	
	public void display() {
		String s1="";
		for (int ve:v) {
			s1+=ve+"\t";
		}
		String s2="";
		int sum=0;
		int[][] mst=createMST();
		for (int i=0;i<mst.length;i++) {
			s2+="edge between vertex"+mst[i][0]+" and vertex"+mst[i][1]+" of weight "+mst[i][2]+"\n";
			sum+=mst[i][2];
		}
		System.out.printf("vertices: %s\n\n",s1);
		System.out.printf("the mst is of total weight %d:\n%s",sum,s2);
	}
	
	public static void main(String[] args) {
		Kruskal i=new Kruskal();
		i.display();
	}

}
