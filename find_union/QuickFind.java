package find_union;

public class QuickFind {
	
	private int[] id;
	
	/*
	 * in this algo, each set of connections are related by having the same item stored
	 * knowing that the integers available for connections are specified as the indices of id
	 * so if i want to establish a connection between p and q, i make sure that id[p]=id[q]=p for example
	 * -it's called quick find because the find takes a really fast running time:
	 * 		find --> O(1)
	 * 		union --> O(n)
	 * -data structure used: array
	 */

	public QuickFind() {
		id=new int[10];
		for (int i=0;i<10;i++)
			id[i]=i;
		//initialize each item to its index, each is connected only to itself
	}
	
	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}

	public boolean find(int p,int q) {
		//takes 2 ints and check whether connected or not
		return id[p]==id[q];
	}
	
	public void union(int p, int q) {
		//takes 2 ints and set ther respective values to the same int
		for (int i=0;i<id.length;i++) {
			if (id[p]==id[i])
				id[i]=id[q];
		}
	}
	
}
