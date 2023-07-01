package DP;

class Solution {
    
    private boolean isLess(int[] a,int[] b){
        //returns if a is less than b
        if ((a[0]<b[0] ))
            return true;
        return false;
    }
    
    private boolean isLessLen(int[] a,int[] b) {
    	//returns if a has a less length than b
    	return a[1]<b[1];
    }
    
    private int[][] merge(int[][] a, int[][] b){
        //merge 2 arrays and returns the outcome
        int[][] c=new int[a.length+b.length][2];
        int i=0;int j=0;int k=0;
        while (i<a.length&& j<b.length){
            if (isLess(a[i],b[j])){
                c[k]=a[i];i++;
            }
            else {
                c[k]=b[j];j++;
            }
            k++;
        }
        while (j<b.length){
            c[k]=b[j];j++;k++;
        }
        while (i<a.length){
            c[k]=a[i];i++;k++;
        }
        return c;
    }
    
    private boolean canFill(int[] a,int[] b){
        //returns whther we can put envelope a in b
        if (a[0]<b[0] &&a[1]<b[1])
            return true;
        return false;
    }
    
    private int[][] sort(int[][] c){
        if (c.length==1 || c.length==0)
            return c;
        int size=c.length;
        int[][] a=new int[size/2][2];
        int[][] b=new int[size-size/2][2];
        for (int i=0;i<size/2;i++){
            a[i]=c[i];
        }
        for (int j=size/2;j<size;j++){
            b[j-size/2]=c[j];
        }
        return merge(sort(a),sort(b));
    }
    
    private void printMatrix(int[][] m) {
    	String s="";
    	for (int i=0;i<m.length;i++) {
    		for (int j=0;j<m[0].length;j++) {
    			s+=m[i][j]+"\t";
    		}
    		s+="\n";
    	}
    	System.out.println(s);
    }
    
    private void printArray(int[] a) {
    	String s="";
    	for (int i=0;i<a.length;i++) {
    		s+=a[i]+"\t";
    	}
    	System.out.println(s);
    }
    
    private int findMax(int[] a) {
    	int max=a[0];
    	for (int i:a) {
    		if (i>max)
    			max=i;
    	}
    	return max;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        int[][] sorted_envelops=sort(envelopes);
        printMatrix(sorted_envelops);
        int[] memo=new int[envelopes.length];
        memo[0]=0;
        //boolean break_bcs_azar_said_so=false;
        for (int i=1;i<memo.length;i++){
        	//break_bcs_azar_said_so=false;
        	for (int j=i-1;j>=0;j--) {
        		//System.out.println(j);
        		if (canFill(sorted_envelops[j],sorted_envelops[i]))
                    {
        				if(memo[i]<memo[j]+1)
        					memo[i]=memo[j]+1;
                    }
        	}
            //if (memo[i]<memo[i-1]) memo[i]=memo[i-1];
        }
        System.out.println("my memo:");
        printArray(memo);
        return findMax(memo)+1;
    }
}

public class RussianDoll {
	public static void main(String[] args) {
		Solution s=new Solution();
		int[][] e= {{5,4},{6,4},{6,7},{2,3}};
		int[][] f={{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
	
        System.out.printf("max # of envelopes is:%d",s.maxEnvelopes(f));
		
	}
}
