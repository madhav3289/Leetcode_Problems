class Solution {
    static int n;
    public boolean predictTheWinner(int[] nums) {
        n=nums.length;
        int diff=helper(nums,0,n-1);
        return diff>=0;
    }
    public static int helper(int [] nums,int i,int j){
        if(i>j){
            return 0;
        }
        if(i==j){
            return nums[i];
        }

        int left=nums[i]-helper(nums,i+1,j);
        int right=nums[j]-helper(nums,i,j-1);

        return Math.max(left,right);
    }
}