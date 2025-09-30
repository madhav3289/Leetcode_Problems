class Solution {
    public int characterReplacement(String s, int k) {
        int max=0;
        for(int i=0;i<26;i++){
            max=Math.max(max,maxConsecutive(s,i,k));
        }
        return max;
    }
    public static int maxConsecutive(String s,int i,int k){
        char sp=(char)(i+'A');
        int max=0;
        int lo=0,hi=0;
        while(hi<s.length()){
            char ch=s.charAt(hi);
            if(sp!=ch){
                k--;
                while(k<0){
                    if(s.charAt(lo)!=sp){
                        k++;
                    }
                    lo++;
                }
            }
            max=Math.max(max,hi-lo+1);
            hi++;
        }
        return max;
    }
}