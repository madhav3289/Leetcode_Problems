class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        return helper(n,1,1);
    }
    public static int helper(int n,int curLen,int lastLen){
        if(curLen==n){
            return 1;
        }
        if(curLen>n){
            return 999999;
        }
        int copyPaste=2+helper(n,curLen*2,curLen);
        int paste=1+helper(n,curLen+lastLen,lastLen);
        return Math.min(copyPaste,paste);
    }
}