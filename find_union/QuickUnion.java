package find_union;

public class QuickUnion {
	
	private int[] id;

	/*
	 * in this algo, the connections are set in a specific tree format,
	 * knowing that the integers available for connections are specified as the indices of id
	 * each 2 connected ints are related in a parent-child relationship where the value each index stores=value of the parent
	 * the root's value is itself
	 * meaning, if p and q are connected, id[p]=q, if q is root id[q]=q
	 * -it's called quick union because union has a better running time
	 * 		find --> O(height of the tree)
	 * 		union --> O(height of the tree)
	 * -data structure used: array
	 */
	public QuickUnion() {
		id=new int[10];
		for (int i=0;i<10;i++)
			id[i]=i;
		//initialize each item to its index, each element is a root
	}
	
	public int root(int p) {
		//running time: height of the tree
		while(id[p]!=p)
			p=id[p];
		return p;
	}
	public boolean find(int p,int q) {
		return root(p)==root(q);
	}
	
	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}

	public void union(int p,int q) {
		int i=root(p);
		int j=root(q);
		id[i]=j;
		//j becomes the root
	}
}
