class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            int val=i+nums[i];
            if(i>max){
                return false;
            }
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