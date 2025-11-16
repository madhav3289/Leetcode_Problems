class Solution {
    static int mod=1_000_000_007;
    public int numSub(String s) {
        long total=0;
        long count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
            else{
                total=(total+(count*(count+1)/2))%mod;
                count=0;
            }
        }
        total=(total+(count*(count+1)/2))%mod;
        return (int)total;
    }
}