class Solution {
    static int n;
    public long maxPower(int[] stations, int r, int k) {
        n=stations.length;
        long [] diffArray=new long[n];
        for(int i=0;i<n;i++){
            int left=Math.max(0,i-r);
            diffArray[left]+=stations[i];
            if(i+r+1<n){
                diffArray[i+r+1]-=stations[i];
            }            
        }
        long lo=minElements(stations);
        long hi=sumElements(stations)+k;
        long ans=-1;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(isPossible(diffArray,mid,r,k)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }
    public static boolean isPossible(long [] diffArray,long mid,int r,int k){
        long [] tempDiff=Arrays.copyOf(diffArray,n);
        long curSum=0;
        for(int i=0;i<n;i++){
            curSum+=tempDiff[i];
            if(curSum<mid){
                long rem=mid-curSum;
                if(rem>k){
                    return false;
                }
                k-=rem;
                curSum+=rem;
                if(i+2*r+1<n){
                    tempDiff[i+2*r+1]-=rem;
                }
            }
        }
        return true;
    }
    public static long minElements(int [] nums){
        long min=nums[0];
        for(int i=1;i<n;i++){
            min=Math.min(min,(long)nums[i]);
        }
        return min;
    }
    public static long sumElements(int [] nums){
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=(long)nums[i];
        }
        return sum;
    }
}