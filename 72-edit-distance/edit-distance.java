class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp=new int[word1.length()][word2.length()];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(word1,word2,0,0,dp);
    }
    public static int helper(String word1,String word2,int idx1,int idx2,int [][] dp){
        if(idx1==word1.length()){
            return word2.length()-idx2;
        }
        if(idx2==word2.length()){
            return word1.length()-idx1;
        }
        if(dp[idx1][idx2]!=-1){
            return dp[idx1][idx2];
        }
        int rep=0,del=0,ins=0;
        if(word1.charAt(idx1)==word2.charAt(idx2)){
            return helper(word1,word2,idx1+1,idx2+1,dp);
        }        
        else{            
            // we can replace
            rep=1+helper(word1,word2,idx1+1,idx2+1,dp);

            // we can delete
            del=1+helper(word1,word2,idx1+1,idx2,dp);            

            // we can insert
            ins=1+helper(word1,word2,idx1,idx2+1,dp);
        }
        return dp[idx1][idx2]=Math.min(rep,Math.min(del,ins));
    }
}