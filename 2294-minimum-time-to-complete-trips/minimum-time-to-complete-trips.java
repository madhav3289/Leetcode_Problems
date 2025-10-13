class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n=time.length;
        long lo=1;
        long hi=1;
        for(int i:time){
            hi=Math.max(hi,i);
        }
        hi=hi*(long)totalTrips;
        long ans=-1;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isPossible(time,totalTrips,mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int [] time,int totalTrips,long mid){
        long total=0;
        for(int i=0;i<time.length;i++){
            long val=mid/time[i];
            total+=val;
            if(total>=totalTrips){
                return true;
            }
        }
        return total>=totalTrips;
    }
}