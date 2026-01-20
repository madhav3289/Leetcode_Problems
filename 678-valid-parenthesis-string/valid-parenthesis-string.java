class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        Boolean [][] dp=new Boolean[n+1][n+1];
        return helper(s,0,0,dp);
    }
    public static boolean helper(String s,int idx,int count,Boolean [][] dp){
        if(idx>=s.length()){
            return count==0;
        }
        if(count<0){
            return false;
        }
        if(dp[idx][count]!=null){
            return dp[idx][count];
        }
        if(s.charAt(idx)=='('){
            return helper(s,idx+1,count+1,dp);
        }
        else if(s.charAt(idx)==')'){
            return helper(s,idx+1,count-1,dp);
        }
        return dp[idx][count]=(helper(s,idx+1,count,dp) || helper(s,idx+1,count+1,dp) || helper(s,idx+1,count-1,dp));        
    }
}