class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=nums.length;
        int result=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int sum=1,count=1;
            for(int j=2;j<=num;j++){
                if(num%j==0){
                    count++;
                    sum+=j;
                }
                if(count>4){
                    break;
                }
            }
            if(count==4){
                result+=sum;
            }
        }
        return result;
    }
}