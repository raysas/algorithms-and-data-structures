package Ex1;

public class Graph {
	
	private char[] v;
	private LL[] e;
	
	private int index(char u) {
		for (int i=0;i<v.length;i++) {
			if (v[i]==u)
				return i;
		}
		return -1;
	}
	
	public Graph() {
		char[] a= {'a','b','c','d','e'};
		v=a;
		e=new LL[v.length];
		//initialize them
		for (int i=0;i<e.length;i++) {
			e[i]=new LL();
		}
		createEdge('e','c');
		createEdge('e','b');
		createEdge('a','b');
		createEdge('a','c');
		createEdge('b','d');
		createEdge('c','a');
		System.out.println("my graph:\n");
		display();
	}

	public char[] getV() {
		return v;
	}

	public void setV(char[] v) {
		this.v = v;
	}

	public LL[] getE() {
		return e;
	}

	public void setE(LL[] e) {
		this.e = e;
	}
	
	public void createEdge(char u, char v) {
		int u_index=index(u);
		int v_index=index(v);
		//if the edge doesn't exist add it; since it's undirected check only one condition the same as checking both
		if(!e[u_index].find(v)) {
			e[u_index].add(v);
			e[v_index].add(u);
		}
	}
	
	public void display() {
		String s="";
		for (int i=0;i<v.length;i++) {
			s+=v[i]+":\t"+e[i].toString()+"\n";
		}
		System.out.println(s);
	}
	
	
	private void DFS(char u, boolean[] track,Stack s) {
		int u_index=index(u);
		System.out.printf("now we're visiting %c\n",u);
		Node neighbour=e[u_index].getHeader();
		while(neighbour!=null) {
			if (!track[index(neighbour.getInfo())]) {
				//push only unvisited neighbors
				s.push(neighbour.getInfo());
				track[index(neighbour.getInfo())]=true;
			}
			neighbour=neighbour.getNext();
		}
		if (s.peek()!=' ') {
			DFS(s.pop(),track,s);
		}
			
	}
	
	public void DFS() {
		boolean [] track=new boolean[v.length];
		Stack s=new Stack(v.length);
		track[0]=true;
		DFS(v[0],track,s);
	}
	
	

}
