class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        int n=time.length;
        long lo=1;
        long hi=(long)time[n-1]*totalTrips;
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
    public static boolean isPossible(int [] time,int totalTrips,long expTime){
        long trips=0;
        int n=time.length;
        for(int i=0;i<n;i++){
            long trip=expTime/(long)time[i];
            trips+=trip;
            if(trips>=totalTrips){
                return true;
            }
        }
        return (trips>=totalTrips);
        
    }
}