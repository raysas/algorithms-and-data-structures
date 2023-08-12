package Ex2;

public class Graph {
	
	private char[]v;
	private boolean[][] e;
	
	private int index(char u) {
		for (int i=0;i<v.length;i++) {
			if (v[i]==u)
				return i;
		}
		return -1;
	}
	
	private void printEdges( )
	{
		String s="\t";
		for (int k=0;k<v.length;k++) {
			s+=v[k]+"\t";
		}
		s+="\n";
		for (int i=0;i<e.length;i++) {
			s+=v[i]+"\t";
			for (int j=0;j<e[0].length;j++) {
				s+=e[i][j]+"\t";
			}
			s+="\n";
		}
		System.out.println(s);
	}
	
	public Graph(int l) {
		v=new char[l];
		e=new boolean[l][l];
	}
	
	public Graph() {
		char[] a= {'A','B','C','D','E','F','G','H','I'};
		v=a;
		e=new boolean[v.length][v.length];
		createEdge('A','C');
		createEdge('A','D');
		createEdge('B','C');
		createEdge('D','C');
		createEdge('E','F');
		createEdge('F','G');
		createEdge('H','I');
		printEdges();
	}
	
	public void createEdge(char u,char v) {
		int u_index=index(u);
		int v_index=index(v);
		if (u_index!=-1 && v_index!=-1) {
			e[u_index][v_index]=true;
			e[v_index][u_index]=true;
		}
		else
			System.out.println("vertices don't exist in this graph :/");
	}
	
	private void BFS(char u, boolean[] track) {
		//tracks the BFS rooted at u
		Queue q=new Queue();
		track[index(u)]=true;
		char temp=u;
		while (temp!=' ') {
			System.out.printf("visiting %c now\n",temp);
			for (int i=0;i<v.length;i++) {
				if (!track[i] && e[i][index(temp)]) {
					track[i]=true;
					q.enqueue(v[i]);
				}
			}
			temp=q.dequeue();
		}
	}
	
	public int getComponents() {
		System.out.println("\tVisits will be following BFS");
		boolean[] visited=new boolean[v.length];
		int c=0;//initialize the # of components to 0
		for (int i=0;i<v.length;i++) {
			if (!visited[i]) {
				c++;
				System.out.printf("\t------------------------\n\t\t Component #%d\n\t------------------------\n",c);
				BFS(v[i], visited);
			}
		}
		return c;
	}

}
