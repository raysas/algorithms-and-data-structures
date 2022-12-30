package DP;

public class MaximumAlignment {
	
	public int max3(int a,int b,int c) {
		if (a<c || a<b)
		{
			if (c<b)
				return b;
			return c;
		}
		return a;
	}
	
	public int max2(int a,int b) {
		if (a>b)
			return a;
		return b;
	}
	
	public String duplicate(String s, int t) {
		String a="";
		for (int i=0;i<t;i++)
			a+=s;
		return s;
	}
	
	public void printTable(int[][] m) {
		String s="";
		for (int i=0;i<m.length;i++) {
			for (int j=0;j<m[0].length;j++)
				s+=m[i][j]+"\t";
			s+="\n";
		}
		System.out.println(s);
	}
	
	public void align(String a, String b) {
		int[][] dp=new int[a.length()+1][b.length()+1];
		for (int i=0;i<=a.length();i++) {
			for (int j=0;j<=b.length();j++){
				if (i==0&& j==0)
					dp[i][j]=0;
				else if (i==0)
					dp[i][j]=dp[i][j-1]-2;
				else if(j==0)
					dp[i][j]=dp[i-1][j]-2;
				else {
					if (a.charAt(i-1)==b.charAt(j-1))
						dp[i][j]=dp[i-1][j-1]+2;
					else dp[i][j]=max3(dp[i-1][j-1]-1,dp[i-1][j]-2,dp[i][j-1]-2);
				}
			}
		}
		printTable(dp);
		//now backtracking: 
		String s1="";String s2="";
		int n=a.length();int m=b.length();
		while (n>0 && m>0) {
			if (dp[n][m]==dp[n-1][m-1]+2 || dp[n][m]==dp[n-1][m-1]-1) {
				s1=a.charAt(n-1)+s1;
				s2=b.charAt(m-1)+s2;
				System.out.println("test");
				n--;
				m--;
			}
			else if (dp[n][m]==dp[n-1][m]-2){
				s1=a.charAt(n-1)+s1;
				s2="-"+s2;
				n--;
			}
			else if (dp[n][m]==dp[n][m-1]-2) {
				s1="-"+s1;
				s2=b.charAt(m-1)+s2;
				m--;
			}
		}
		int d;
		if (n>1) {
			d=a.length()-n;
			s1=s1.substring(0, n);
			s2=duplicate("-",d)+s2;
		}
		else if (m>1) {
			d=b.length()-m;
			s2=s2.substring(0, m);
			s1=duplicate("-",d)+s1;
		}
		System.out.println();
		System.out.printf("string 1:%s\nstring 2:%s",s1,s2);
	}
	
	public static void main(String[] args) {
		MaximumAlignment s=new MaximumAlignment();
		s.align("AABB", "ABAA");
	}

}
