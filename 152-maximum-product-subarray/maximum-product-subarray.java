class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int cmax=1,cmin=1;
        for(int i=0;i<nums.length;i++){
            int temp=cmax*nums[i];

            cmax=Math.max(temp,Math.max(cmin*nums[i],nums[i]));
            cmin=Math.min(temp,Math.min(cmin*nums[i],nums[i]));

            max=Math.max(max,cmax);
        }
        return max;
    }
}