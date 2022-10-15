package find_union;

public class WeightedUnion {

	private int[] id;
	private int[] size;
	//great for huge practical problems
	
	/*
	 * easy modification to quick-union
	 * bad cases do not occur (where height becomes N-1)
	 * logarithmic function
	 * keep track of the size of each tree and always connect the smaller tree to the larger
	 */
	
	public WeightedUnion() {
		id=new int[10];
		for (int i=0;i<10;i++) {
			id[i]=i;
			size[i]=1;
		}
			
		//initialize each item to its index, each element is a root
		//size of each tree is one (only root)
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
	public void union(int p,int q) {
		int i=root(p);
		int j=root(q);
		if (size[i]>size[j]) {//tree of i is bigger than tree of j
			id[j]=i;//i root of j
			size[i]+=size[j];
		}
		else {
			id[i]=j;//j becomes root of i
			size[j]+=size[i];
		}
		//j becomes the root
	}
}
