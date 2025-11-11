class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int [][] nums=new int[len][2];
        int idx=0;
        for(String s:strs){
            int cz=0,co=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    co++;
                }
                else{
                    cz++;
                }
            }
            nums[idx][0]=cz;
            nums[idx][1]=co;
            idx++;
        }
        // [[1,1],[3,1],[2,4],[0,1],[1,0]];
        int [][][] dp=new int[idx][m+1][n+1];
        for(int [][] arr:dp){
            for(int [] a:arr){
                Arrays.fill(a,-1);
            }
        }
        return helper(nums,m,n,0,dp);
    }
    public static int helper(int [][] nums,int m,int n,int idx,int [][][] dp){
        if(m<0 || n<0 || idx>=nums.length){
            return 0;
        }
        if(dp[idx][m][n]!=-1){
            return dp[idx][m][n];
        }
        int inc=0;
        if(m-nums[idx][0]>=0 && n-nums[idx][1]>=0){
            inc=1+helper(nums,m-nums[idx][0],n-nums[idx][1],idx+1,dp);
        }
        int exc=helper(nums,m,n,idx+1,dp);
        return dp[idx][m][n]=Math.max(inc,exc);
    }
}