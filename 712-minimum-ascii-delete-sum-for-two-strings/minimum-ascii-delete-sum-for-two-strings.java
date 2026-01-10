class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int [][] dp=new int[s1.length()][s2.length()];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(s1,s2,0,0,dp);
    }
    public static int helper(String s1,String s2,int idx1,int idx2,int [][] dp){
        if(idx1==s1.length()){
            int c=0;
            for(int i=idx2;i<s2.length();i++){
                c+=s2.charAt(i);
            }
            return c;
        }
        if(idx2==s2.length()){
            int c=0;
            for(int i=idx1;i<s1.length();i++){
                c+=s1.charAt(i);
            }
            return c;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        if(s1.charAt(idx1)==s2.charAt(idx2)){
            return helper(s1,s2,idx1+1,idx2+1,dp);
        }
        int takeS1=s1.charAt(idx1)+helper(s1,s2,idx1+1,idx2,dp);
        int takeS2=s2.charAt(idx2)+helper(s1,s2,idx1,idx2+1,dp);
        return dp[idx1][idx2]=Math.min(takeS1,takeS2);
    }
}