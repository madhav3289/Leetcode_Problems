class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=(sum+nums[i])%p;
        }
        int target=sum%p;
        if(target==0){
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int cSum=0;
        map.put(cSum,-1);
        int minSize=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            cSum=(cSum+nums[i])%p;
            int rem=(cSum-target+p)%p;
            if(map.containsKey(rem)){
                minSize=Math.min(minSize,i-map.get(rem));
            }
            map.put(cSum,i);
        }
        if(minSize==Integer.MAX_VALUE || minSize==n){
            return -1;
        }
        return minSize;
    }
}