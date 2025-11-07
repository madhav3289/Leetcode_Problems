class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int i=0;
        int count=0;
        while(i<n-1){
            int val=nums[i];
            if(i+val>=n-1){
                count++;
                break;
            }
            int maxi=val;
            int temp=i+1;
            for(int j=i+1;j<=i+val && j<n;j++){
                if(j+nums[j]>maxi){
                    maxi=j+nums[j];
                    temp=j;
                }
            }
            i=temp;
            count++;
        }
        return count;
    }
}