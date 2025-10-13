class Solution {
    public int partitionArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=1;
        int start=nums[0];
        for(int i=1;i<n;i++){
            int d=nums[i]-start;
            if(d>k){
                count++;
                start=nums[i];
            }
        }
        return count;
    }
}