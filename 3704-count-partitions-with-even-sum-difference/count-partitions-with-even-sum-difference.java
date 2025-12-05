class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int [] left=new int[n];
        left[0]=nums[0];
        for(int i=1;i<n;i++){
            left[i]=left[i-1]+nums[i];
        }
        // [10,20,23,30,36]
        int [] right=new int[n];
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]+nums[i];
        }
        // [36,26,16,13,6]
        int count=0;
        for(int i=0;i<n-1;i++){
            if(((right[i]-nums[i])-left[i])%2==0){
                count++;
            }
        }
        return count;
    }
}