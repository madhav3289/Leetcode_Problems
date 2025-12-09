class Solution {
    public int specialTriplets(int[] nums) {
        int mod=1_000_000_007;
        int n=nums.length;
        Map<Integer,Integer> left=new HashMap<>();
        Map<Integer,Integer> right=new HashMap<>();
        for(int i=0;i<n;++i){
            right.put(nums[i],right.getOrDefault(nums[i],0)+1);
        }
        long ans=0;
        for(int i=0;i<n;++i){
            int num=nums[i];
            right.put(num,right.get(num)-1);
            int val=num*2;
            long lc=left.getOrDefault(val,0);
            long rc=right.getOrDefault(val,0);
            ans=(ans+(lc*rc)%mod)%mod;
            left.put(num,left.getOrDefault(num,0)+1);
        }
        return (int)ans;        
    }
}