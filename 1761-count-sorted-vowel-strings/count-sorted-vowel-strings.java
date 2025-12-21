class Solution {
    public int countVowelStrings(int n) {
        int [][] dp=new int[n][5];
        Arrays.fill(dp[0],1);
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3]+dp[i-1][4];
            dp[i][1]=dp[i-1][1]+dp[i-1][2]+dp[i-1][3]+dp[i-1][4];
            dp[i][2]=dp[i-1][2]+dp[i-1][3]+dp[i-1][4];
            dp[i][3]=dp[i-1][3]+dp[i-1][4];
            dp[i][4]=dp[i-1][4];
        }
        int sum=0;
        for(int e:dp[n-1]){
            sum+=e;
        }
        return sum;
    }
    // recursive code

    // public int countVowelStrings(int n) {
    //     count=0;
    //     helper(n,0);
    //     return count;
    // }
    // static int count=0;
    // public static void helper(int n,int idx){
    //     if(n==0){
    //         count++;
    //         return;
    //     }
    //     for(int i=0;i<5;i++){
    //         if(i>=idx){
    //             helper(n-1,i);
    //         }
    //     }
    // }
}