class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            if(i>max){
                return false;
            }
            int val=i+nums[i];
            if(val>max){
                max=val;
            }
            if(max>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}