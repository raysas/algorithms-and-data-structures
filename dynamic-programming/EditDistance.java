public class EditDistance{
  /*
 * finally...............
 * 		--------------------------------------------------------------------------------------------
 * 
 * 										Rayane Adam
 * 										202100578
 * 										CP3- ASSIGNMENT 3
 * 										DYNAMIC PROGRAMMING
 * 										Last modified: 1:01PM 11/6/2022
 * 
 * ALGORITHM:
 * 
 * 	-the formula:
 * 									t[i-1][j-1] 							if word1[i]==word2[j]
 * 					t[i][j]=
 * 									min(t[i-1][j-1],t[i-1][j],t[i][j-1])+1	otherwise
 * now for the base cases: 	if word1[0]=word2[0] (meaing we're comparing 2 identical chars to edit, no need for edit) then t[0][0]=0,
 * 								otherwise, we need to replace one with the other, executing one operation (replace) thus t[0][0]=1
 * 							if i=0, don't look diagonally, nor upward, look to the left
 * 										increment by 1 if not identical
 * 										leave as the left value otherwise
 * 							if j=0, don't look diagonally, nor to the left, look up
 * 										increment by 1 if not identical
 * 										leave as the above value otherwise
 * 
 * 	NOW LOGIC:
 * 		-t[i][j]: the minimum operations to edit distance between s1[:i] and s2[:j]
 * 		
 * 		in short, if we have 2 sub-strings (considering them in the subproblems as the strings to study their edit distance)
 * 							s1[:n] and s2[:m] with a min_edit_distance=k
 * 				to take a string s1[:n+1] and s2[:m+1] and study their edit distance do the following:
 * 					if s1[n+1]==s[m+1] then minEditDistance(s1[:n+1] and s2[:m+1])=minEditDistance(s1[:n] and s2[:m])
 * 					else minEditDistance(s1[:n+1] and s2[:m+1])=minEditDistance(s1[:n] and s2[:m])+1
 * 							(to have minimum operations we need to replace s1[n+1] by s2[m+1] 
 * 								=> add one operation to the minimum amount of operations to transform s1[:n] to s[:m])
 * 			our objective is to get minimum edit distance of s1 and s2, thus the cell we're looking for is the last cell in the matrix
 *	
 *
 *`no need for backtracking :P`
 *
 */
	
	private String a;
	private String b;
	
	public EditDistance() {
		a="hello";
		b="ellen";
	}
	
	public EditDistance(String w1,String w2) {
		a=w1.toLowerCase();b=w2.toLowerCase();
	}
	
	//now the helper methods i'm gonna use to make sure it''s working fine:
		
		private void printMatrix(int[][] m) {
			String s="";
			for (int i=0;i<m.length;i++) {
				if (i==0) {
					s+="\t";
					for (int j=0;j<m[0].length;j++) {
						s+=a.charAt(j)+"\t";
					}
					s+="\n";
				}
				s+=b.charAt(i)+"\t";
				for (int j=0;j<m[0].length;j++) {
					s+=m[i][j]+"\t";
				}
				s+="\n";
			}
			System.out.println(s);
		}
		
		private int getMin(int n,int m, int p) {
			if(n>m ||n>p) {
				if (m<p) return m;
				return p;
			}
			else return n;
		}
	
	public int[][] getMatrix(){
		if(a.equals(b))
		{
			int[][] m=new int[1][1];
			m[0][0]=0;
			return m;
		}
		 else if (a.equals("")||b.equals(""))
		{
			int[][] m=new int[1][1];
			if (a.equals("")) 
				m[0][0]=b.length();
			else m[0][0]=a.length();
			return m;
		}
		int[][] t=new int[b.length()][a.length()];
		for (int i=0;i<t.length;i++) {
			boolean found1=false;boolean found2=false;
			for (int j=0;j<t[0].length;j++) {
					if (i==0 && j==0) {
						if (a.charAt(j)==b.charAt(i)) {
							found1=true;found2=true;
							t[i][j]=0;
						}
						else t[i][j]=1;
					}
					else if (i==0) {
						if (a.charAt(j)==b.charAt(i) && !found1) {
							found1=true;
							t[i][j]=t[i][j-1];
						}
						else t[i][j]=t[i][j-1]+1;
					}
					else if(j==0 ) {
						if (a.charAt(j)==b.charAt(i)&& !found2) {
							found2=true;
							t[i][j]=t[i-1][j];
						}
						else t[i][j]=t[i-1][j]+1;
					}
					else {
						if (a.charAt(j)==b.charAt(i))
							t[i][j]=t[i-1][j-1];
						else {
							t[i][j]=getMin(t[i-1][j],t[i][j-1],t[i-1][j-1])+1;
						}
					}
			}
		}
		printMatrix(t);
		return t;
	}
	public void solve() {
		System.out.println("the table:p");
		int[][] m=getMatrix();
		int min_op=m[m.length-1][m[0].length-1];
		System.out.println();
		System.out.printf("the minimum #of ops to convert \"%s\" to \"%s\" is: %d",a,b,min_op);
	}
	public static void main(String[] args) {
		EditDistance p1=new EditDistance("pneumonoultramicroscopicsilicovolcanoconiosis","ultramicroscopically");
		EditDistance p2=new EditDistance();
		p2.solve();
	}

}
