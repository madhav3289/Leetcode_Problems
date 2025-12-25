class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxLen=-1;
        int st=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(helper(s,i,j)){
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        st=i;
                    }
                }
            }
        }
        return s.substring(st,st+maxLen);
    }
    public static boolean helper(String s,int i,int j){
        if(i>=j){
            return true;
        }
        if(s.charAt(i)==s.charAt(j)){
            return helper(s,i+1,j-1);
        }
        return false;
    }
}