class Solution {
    static String [] states={"RYR","RYG","RGR","RGY","YRY","YRG","YGR","YGY","GRY","GRG","GYR","GYG"};
    static int mod=1_000_000_007;

    static int [][] dp;
    public int numOfWays(int n) {
        int result=0;
        dp=new int[n][12];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        for(int i=0;i<12;i++){
            result=(result+helper(n-1,i))%mod;
        }
        return result;
    }
    public static int helper(int n,int prev){
        if(n==0){
            return 1;
        }
        if(dp[n][prev]!=-1){
            return dp[n][prev];
        }
        int result=0;
        String pStr=states[prev];
        for(int i=0;i<12;i++){
            if(i==prev){
                continue;
            }
            String cStr=states[i]; 
            boolean conflict=false;
            for(int j=0;j<3;j++){
                if(cStr.charAt(j)==pStr.charAt(j)){
                    conflict=true;
                    break;
                }
            }
            if(!conflict){
                result=(result+helper(n-1,i))%mod;
            }
        }
        return dp[n][prev]=result;
    }
}