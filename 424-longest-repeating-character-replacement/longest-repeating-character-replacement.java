class Solution {
    public int characterReplacement(String s, int k) {
        int max=0;
        for(int i=0;i<26;i++){
            max=Math.max(max,longestReplacement(s,k,i));
        }
        return max;
    }
    public static int longestReplacement(String s,int k,int i){
        char ch=(char)(i+'A');
        int lo=0,hi=0;
        int max=0;
        while(hi<s.length()){
            char temp=s.charAt(hi);
            if(temp!=ch){
                k--;
                
            }
            while(k<0){
                char x=s.charAt(lo);
                if(x!=ch){
                    k++;
                }
                lo++;
            }
            
            max=Math.max(max,hi-lo+1);
            hi++;
        }
        return max;
    }
}