class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        long [] prefix=new long[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int result=0;
        for(int i=0;i<n;i++){
            result=Math.max(result,binarySearch(nums,k,i,prefix));
        }
        return result;
    }
    public static int binarySearch(int [] nums,int k,int idx,long [] prefix){
        int val=nums[idx];
        int lo=0;
        int hi=idx;
        int ans=idx;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;

            long total=val*(idx-mid+1);
            long curr=prefix[idx]-prefix[mid]+nums[mid];
            int opr=(int)(total-curr);
            if(opr>k){
                lo=mid+1;
            }
            else{
                ans=mid;
                hi=mid-1;
            }
        }
        return idx-ans+1;
    }
}