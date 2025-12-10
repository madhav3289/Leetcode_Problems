class Solution {
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        int mod=1_000_000_007;
        long ans=1;
        for(int i=1;i<n;i++){
            if(complexity[i]<=complexity[0]){
                return 0;
            }
            else{
                ans=(ans*i)%mod;
            }
        }
        return (int)ans;
    }
}