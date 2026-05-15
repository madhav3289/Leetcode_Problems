class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                flag=true;
            }
            if(nums[i]<=0 || nums[i]>n){
                nums[i]=1;
            }
        }
        if(!flag){
            return 1;
        }
        for(int i=0;i<n;i++){
            int num=Math.abs(nums[i])-1;
            if(nums[num]>0){
                nums[num]=-1*nums[num];
            }
        }
        int max=n;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                max=i;
                break;
            }
        }
        return max+1;
    }
}