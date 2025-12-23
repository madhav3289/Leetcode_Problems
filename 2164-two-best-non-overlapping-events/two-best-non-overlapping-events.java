class Solution {
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        // sorting logic
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int [][] dp=new int[n][3];
        for(int [] ar:dp){
            Arrays.fill(ar,-1);
        }
        return helper(events,0,2,dp);
    }
    public static int helper(int [][] events,int idx,int total,int [][] dp){
        if(total==0 || idx>=events.length){
            return 0;
        }
        if(dp[idx][total]!=-1){
            return dp[idx][total];
        }
        // find the next index where starting time is greater than current ending time
        int nV=nextValid(events,idx);
        // either we can include this event
        int inc=events[idx][2]+helper(events,nV,total-1,dp);
        // or we can exclude this event
        int exc=helper(events,idx+1,total,dp);
        return dp[idx][total]=Math.max(inc,exc);
    }
    // calculate upper bound using binary serach
    public static int nextValid(int [][] events,int idx){
        int lo=0;
        int hi=events.length-1;
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(events[mid][0]>events[idx][1]){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans==-1?events.length:ans;
    }
}