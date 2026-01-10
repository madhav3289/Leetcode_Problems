class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1){
            return nums[0];
        }
        int count=0,zero=0;
        for(int num:nums){
            if(num<0){
                count++;
            }
        }
        int req=count;
        if(count%2!=0){
            req--;
        }
        long res=1;
        boolean used=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 && req!=0){
                res*=nums[i];
                req--;
                used=true;
            }
            else if(nums[i]>0){
                res*=nums[i];
                used=true;
            }
        }
        return (used)?res:0;
    }
}