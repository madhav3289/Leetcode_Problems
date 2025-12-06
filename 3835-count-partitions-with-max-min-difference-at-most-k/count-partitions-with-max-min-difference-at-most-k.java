class Solution {
    public int countPartitions(int[] nums, int k) {
        int n=nums.length;
        int mod=1_000_000_007;
        int [] dp=new int[n+1];
        int [] prefix=new int[n+1];
        prefix[0]=1;
        dp[0]=1;

        TreeMap<Integer,Integer> map=new TreeMap<>();
        int j=0;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(j<=i && (map.lastKey()-map.firstKey())>k){
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j])==0){
                    map.remove(nums[j]);
                }
                j++;
            }
            if(j>0){
                dp[i+1]=(prefix[i]-prefix[j-1]+mod)%mod;
            }
            else{
                dp[i+1]=prefix[i]%mod;
            }
            prefix[i+1]=(prefix[i]+dp[i+1])%mod;
        }
        return dp[n];
    }

    // MEMOIZATION SOLUTION -> O(N^2) -> TLE

    // public int countPartitions(int[] nums, int k) {
    //     n=nums.length;
    //     int [] dp=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return helper(nums,k,0,dp);
    // }
    // static int n;
    // static int mod=1_000_000_007;
    // public static int helper(int [] nums,int k,int idx,int [] dp){
    //     if(idx==nums.length){
    //         return 1;
    //     }
    //     if(dp[idx]!=-1){
    //         return dp[idx];
    //     }
    //     int count=0;
    //     int min=nums[idx];
    //     int max=nums[idx];
    //     for(int i=idx;i<nums.length;i++){
    //         min=Math.min(min,nums[i]);
    //         max=Math.max(max,nums[i]);
    //         if(max-min>k){
    //             break;
    //         }
    //         count=(count+helper(nums,k,i+1,dp))%mod;
    //     }
    //     return dp[idx]=count;
    // }
}