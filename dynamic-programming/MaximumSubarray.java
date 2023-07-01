public class MaximumSubarray{
  public int maxSubArray(int[] nums) {
        int[] a=new int[nums.length];
        a[0]=nums[0];
        int max=a[0];
        for (int i=1;i<a.length;i++){
            if (nums[i]+a[i-1]>nums[i])
                a[i]=nums[i]+a[i-1];
            else a[i]=nums[i];
            if (a[i]>max)
                max=a[i];
        }
        return max;
        
    }
}
