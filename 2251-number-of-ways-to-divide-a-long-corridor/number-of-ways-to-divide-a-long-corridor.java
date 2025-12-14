class Solution {
    public int numberOfWays(String corridor) {
        int n=corridor.length();
        int [][] dp=new int[n][3];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(corridor,0,0,dp);
    }
    static int mod=1_000_000_007;
    public static int helper(String corridor,int idx,int curr,int [][] dp){
        if(idx==corridor.length()){
            if(curr==2){
                return 1;
            }
            return 0;
        }
        if(dp[idx][curr]!=-1){
            return dp[idx][curr];
        }
        int count=0;
        // current character kya hai
        char ch=corridor.charAt(idx);
         // if the character is 'S' we check for the value of current
        if(ch=='S'){
            // if value is less than 2 we need to include this in current section
            if(curr<2){
                count=(count+helper(corridor,idx+1,curr+1,dp))%mod;
            }
            // otherwise we can start a new section from this
            if(curr==2){
                count=(count+helper(corridor,idx+1,1,dp))%mod;
            }
        }
        // if the character is 'P' we again need to check for value of current
        else if(ch=='P'){
            // if value is less than 2 we need to include this in current section
            if(curr<2){
                count=(count+helper(corridor,idx+1,curr,dp))%mod;
            }
            // if the value is equal to 2 we again have two choices
            else if(curr==2){
                // we are including this index in current section
                count=(count+helper(corridor,idx+1,curr,dp))%mod;
                // we are starting a new section from this;
                count=(count+helper(corridor,idx+1,0,dp))%mod;
            }
        }
        return dp[idx][curr]=count;
    }
}