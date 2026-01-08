class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int [][] dp=new int[n][m];
        for(int [] arr:dp){
            Arrays.fill(arr,Integer.MIN_VALUE/2);
        }
        return helper(nums1,nums2,0,0,dp);
    }
    public static int helper(int [] nums1,int [] nums2,int idx1,int idx2,int [][] dp){
        if(idx1>=nums1.length || idx2>=nums2.length){
            return Integer.MIN_VALUE/2;
        }
        if(dp[idx1][idx2]!=Integer.MIN_VALUE/2){
            return dp[idx1][idx2];
        }
        // include both the index 1 and index2..
        int val=nums1[idx1]*nums2[idx2];
        int inc1=Math.max(val,val+helper(nums1,nums2,idx1+1,idx2+1,dp));
        // include idx1 but exclude idx2..
        int inc2=helper(nums1,nums2,idx1+1,idx2,dp);
        // include idx2 but exclude idx1..
        int inc3=helper(nums1,nums2,idx1,idx2+1,dp);

        return dp[idx1][idx2]=Math.max(inc1,Math.max(inc2,inc3));
    }
}