class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        HashMap<Integer,Integer> hash=new HashMap<>();
        hash.put(0,1);
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            count+=hash.getOrDefault(sum-k,0);
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }
        return count;
    }
}