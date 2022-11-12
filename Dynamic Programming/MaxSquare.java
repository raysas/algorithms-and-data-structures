public class MaxSquare {
  
      private int min(int a,int b,int c){
        if (a>b && a>c){
            if (b<c)
                return b;
            return c;
        }
        else if (a>b)
            //only greater than b
            return b;
        else if(a>c)
            return c;
        return a;
    }
    private int getC(char c){
        if (c=='1')
        	return 1;
        return 0;
    }
    public int maximalSquare(char[][] matrix) {
        int[][] t=new int[matrix.length][matrix[0].length];
        int max=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='0')
                    t[i][j]=0;
                else if(i==0|| j==0)
                    t[i][j]=getC(matrix[i][j]);
                else{
                    t[i][j]=min(getC(matrix[i-1][j]),getC(matrix[i-1][j-1]),getC(matrix[i][j-1]))+1;
                    if (t[i][j]>max)
                        max=t[i][j];
                }
            }
        }
        return max*max;
    }
}
  
	public static void main(String[] args) {
		Solution2 s=new Solution2();
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(s.maximalSquare(matrix));
	}
}
