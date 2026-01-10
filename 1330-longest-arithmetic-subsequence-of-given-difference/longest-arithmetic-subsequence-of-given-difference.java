class Solution {
    public int longestSubsequence(int[] nums, int diff) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=1;
        for(int i=0;i<n;i++){
            int num=nums[i]-diff;
            int numLen=map.getOrDefault(num,0)+1;
            map.put(nums[i],numLen);
            maxLen=Math.max(maxLen,numLen);
        }
        return maxLen;
    }
    // public int longestSubsequence(int[] nums, int diff) {
    //     int n=nums.length;
    //     int [][] dp=new int[n+1][n+1];
    //     for(int [] arr:dp){
    //         Arrays.fill(arr,-1);
    //     }
    //     return helper(nums,diff,0,-1,dp);
    // }
    // public static int helper(int [] nums,int diff,int idx,int prevIdx,int [][] dp){
    //     if(idx>=nums.length){
    //         return 0;
    //     }
    //     if(dp[idx][prevIdx+1]!=-1){
    //         return dp[idx][prevIdx+1];
    //     }
    //     int take=0;
    //     if(prevIdx==-1 || nums[idx]-nums[prevIdx]==diff){
    //         take=1+helper(nums,diff,idx+1,idx,dp);
    //     }
    //     int skip=helper(nums,diff,idx+1,prevIdx,dp);
    //     return dp[idx][prevIdx+1]=Math.max(take,skip);
    // }
}