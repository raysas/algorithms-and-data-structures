public class MaxRectangle {
	
	private final static int[] e= {0,0};
	
	private static boolean empty(int[]a) {
		return (a[0]==0 && a[1]==0);
	}
	
	private static void printMatrix(int[][][] t){
		//table of arrays
		String s="";
		for (int i=0;i<t.length;i++) {
			for (int j=0;j<t[0].length;j++) {
				s+="["+t[i][j][0]+", "+t[i][j][1]+"]\t";
			}
			s+="\n";
		}
		System.out.println(s);
	}
	
	private static int updateMax(int[] a,int max) {
		//if b is larger than max make max=b
		int b=getProduct(a);
		if (b>max)
			return b;
		return max;
	}
	
	private static int getProduct(int[] a) {
		if (empty(a)) return 0;
		return a[0]*a[1];
	}
	
	private static int getMin(int a,int b,int c) {
		if (a>b || a>c) {
			if (b>c)
				return c;
			return b;
		}
		return a;
	}
	
	public static int maximalRectangle(int[][] a) {
		int max_product=0;
		int[] temp= {1,1};
		int[][][] t=new int[a.length][a[0].length][2];
		if (a[0][0]==0)t[0][0]=e;
		else {
			t[0][0]=temp;
			max_product=updateMax(t[0][0],max_product);
		}
		//initialize the rows
		for (int i=1;i<a.length;i++) {
			if (a[i][0]==0)
				t[i][0]=e;
			else {
				t[i][0][0]=1;
				t[i][0][1]=t[i-1][0][1]+1;
			}
			max_product=updateMax(t[i][0],max_product);
		}
		//initialize the columns
		for (int i=1;i<a[0].length;i++) {
			if (a[0][i]==0)
				t[0][i]=e;
			else {
				t[0][i][0]=1;
				t[0][i][1]=t[0][i-1][1]+1;
			}
			max_product=updateMax(t[0][i],max_product);
		}
		//now start filling the table
		for (int i=1;i<t.length;i++) {
			for(int j=1;j<t[0].length;j++) {
				if (a[i][j]==0)
					t[i][j]=e;
				else if(!empty(t[i-1][j]) && !empty(t[i][j-1])&& !empty(t[i-1][j-1])) {
					t[i][j][0]=getMin(t[i-1][j-1][0],t[i][j-1][0],t[i-1][j][0])+1;
					t[i][j][1]=getMin(t[i-1][j-1][1],t[i][j-1][1],t[i-1][j][1])+1;
				}
				else if(empty(t[i-1][j]) && empty(t[i][j-1]))
					t[i][j]=temp;
				else if(empty(t[i-1][j])) {
					t[i][j][0]=t[i][j-1][0]+1;
					t[i][j][1]=1;
				}
				else if(empty(t[i][j-1])) {
					t[i][j][0]=1;
					t[i][j][1]=t[i-1][j][1];
				}
				else {
					if (t[i][j-1][0]>t[i-1][j][1]) {
						t[i][j][0]=t[i][j-1][0]+1;
						t[i][j][1]=1;
					}
					else {
						t[i][j][1]=t[i-1][j][1]+1;
						t[i][j][0]=1;
					}
				}
				max_product=updateMax(t[i][j],max_product);
//				System.out.println(max_product);
			}
		}
		printMatrix(t);
		System.out.printf("\nthe area of the largest rectangle is=%d",max_product);
		return max_product;
	}
	
	
	public static void main(String[] args) {
		int[][] a= {
				{1,0,1,1,0,1},
				{1,1,1,0,0,1},
				{1,1,1,0,1,1},
				{1,1,1,1,1,1}
		};
		int[][] b={{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
		maximalRectangle(b);
	}

}
