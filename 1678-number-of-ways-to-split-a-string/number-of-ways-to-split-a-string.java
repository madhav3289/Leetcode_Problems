class Solution {
    static int mod=1_000_000_007;
    public int numWays(String s) {
        int n=s.length();
        int count=0;
        // count the occurences of 1 in the string
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                count++;
            }
        }
        // if count is not divisble by 3, then we cann't divide it into 3 parts with equal 1's
        if(count%3!=0){
            return 0;
        }
        // if count of 3 is 0, we can just find the total combination of string
        if(count==0){
            // string length 5, total=6 ((n-1)*(n-2))/2 
            // string length 4, total=6 ((n-1)*(n-2))/2
            long val=((long)(n-1)*(long)(n-2))/2;
            return (int)((long)val%mod);
        }
        // how many 1's are required in each splitted string
        int req=count/3;

        count=0;
        long v1=0,v2=0;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                count++;
            }
            if(count==req){
                v1++;
            }
            if(count==req*2){
                v2++;
            }
        }
        return (int)((v1*v2)%mod);
    }
}