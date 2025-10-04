class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int [] memo=new int[n];
        Arrays.fill(memo,-1);
        return helper(nums,0,memo);
    }
    public static int helper(int [] nums,int idx,int [] memo){
        if(idx>=nums.length){
            return 0;
        }
        if(memo[idx]!=-1){
            return memo[idx];
        }
        // we can either rob one house and then skip one and move to another
        int inc=nums[idx]+helper(nums,idx+2,memo);
        // or we can skip current house and move to next house
        int exc=helper(nums,idx+1,memo);
        return memo[idx]=Math.max(inc,exc);
    }
}