class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int ones=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) ones++;
        }
        if(ones>0) return n-ones;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int val=nums[i];
            for(int j=i+1;j<n;j++){
               val=gcd(val,nums[j]);
                if(val==1){
                    mini=Math.min(mini,j-i+1);
                    break;
                }
            }
        }
        return (mini==Integer.MAX_VALUE)?-1:(n-1)+(mini-1);
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}