class Solution {
    public int minPairSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int lo=0,hi=n-1;
        int max=0;
        while(lo<=hi){
            int sum=nums[lo]+nums[hi];
            max=Math.max(max,sum);
            lo++;
            hi--;
        }
        return max;
    }
}