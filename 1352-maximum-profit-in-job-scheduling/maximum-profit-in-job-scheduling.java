class Solution {
    // Method 2 >> Binary Search + DP <<
    static int n;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n=startTime.length;
        int [][] nums=new int[n][3];
        for(int i=0;i<n;i++){
            nums[i]=new int[]{startTime[i],endTime[i],profit[i]};
        }
        // sorting logic (sort them on the basis of ending time so it will become easy for us to use binary search to find next valid index..)
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        int [] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    public static int helper(int [][] nums,int idx,int [] dp){
        // index out of bound check
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        // find the next valid index 
        int validIdx=findIndex(idx,nums);
        // include the current index if possible
        int take=nums[idx][2]+helper(nums,validIdx,dp);
        // skip the current index
        int skip=helper(nums,idx+1,dp);
        return dp[idx]=Math.max(take,skip);
    }
    public static int findIndex(int idx,int [][] nums){
        // start with index greater than previous
        int lo=idx+1;
        int hi=n-1;
        int ans=n;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            // if the start time of current meeting  is more than equal to prev. meeting store the answer and look for  more smaller answer
            if(nums[idx][1]<=nums[mid][0]){
                ans=mid;
                hi=mid-1;
            }
            // else look for higher index..
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}

    // Method 1 >> DP (Top-Down) solution << (MLE)

    // public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    //     n=startTime.length;
    //     int [][] nums=new int[n][3];
    //     for(int i=0;i<n;i++){
    //         nums[i]=new int[]{startTime[i],endTime[i],profit[i]};
    //     }
    //     Arrays.sort(nums,(a,b)->a[1]-b[1]);
    //     int [][] dp=new int[n][n+1];
    //     for(int [] arr:dp){
    //         Arrays.fill(arr,-1);
    //     }
    //     return helper(nums,0,-1,dp);
    // }
    // public static int helper(int [][] nums,int idx,int prevIdx,int [][] dp){
    //     if(idx>=n){
    //         return 0;
    //     }
    //     if(dp[idx][prevIdx+1]!=-1){
    //         return dp[idx][prevIdx+1];
    //     }
    //     int take=0,skip1=0;
    //     if(prevIdx==-1 || nums[prevIdx][1]<=nums[idx][0]){
    //         take=nums[idx][2]+helper(nums,idx+1,idx,dp);
    //         skip1=helper(nums,idx+1,prevIdx,dp);
    //     }
    //     int skip2=helper(nums,idx+1,prevIdx,dp);
    //     return dp[idx][prevIdx+1]=Math.max(take,Math.max(skip1,skip2));
    // }
// }