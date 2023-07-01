public class MaximumProductSubarray{
  //leetcode 
  public int max(int a,int b){
        if (a>b)
            return a;
        return b;
    }
    public int min(int a,int b){
        if (a<b)
            return a;
        return b;
    }
    
    public int maxProduct(int[] nums) {
        int[] max=new int[nums.length];
        //keeps track of the max product possible up to each index in nums
        int[] min=new int[nums.length];
        //keeps track of the min product possible up to each index in nums
        max[0]=nums[0];min[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]<0 ){
              //when negative the max becomes - and the min becomes + switch places
                max[i]=max(min[i-1]*nums[i],nums[i]);
                min[i]=min(max[i-1]*nums[i],nums[i]);
            }
            else{
                max[i]=max(max[i-1]*nums[i],nums[i]);
                min[i]=min(min[i-1]*nums[i],nums[i]);
            }
            System.out.printf("max:%d\tmin:%d\n",max[i],min[i]);
        }
        int k=max[0];
        for (int j:max)
            if (j>k)
                k=j;
        return k;
    }
}
