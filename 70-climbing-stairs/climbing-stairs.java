class Solution {
    public int climbStairs(int n) {
        int [] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return helper(n,memo);
    }
    public static int helper(int n,int [] memo){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(memo[n]!=-1){
            return memo[n];
        }
        int a=helper(n-1,memo);
        int b=helper(n-2,memo);
        return memo[n]=a+b;
    }
}