class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int len=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=0;
            for(int j=i;j<n;j++){
                num=nums[j]|num;
                if(num>=k){
                    if(len>j-i+1){
                        len=j-i+1;
                    }
                }
            }
        }
        return (len==Integer.MAX_VALUE)?-1:len;
    }
}