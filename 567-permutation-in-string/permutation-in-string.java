class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] freq=new int[26];
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            freq[ch-'a']++;
        }
        int lo=0,hi=0;
        while(hi<s2.length()){
            char x=s2.charAt(hi);
            freq[x-'a']--;
            if(hi-lo+1>s1.length()){
                char ch=s2.charAt(lo);
                freq[ch-'a']++;
                lo++;
            }
            if(hi-lo+1==s1.length() && isZero(freq)){
                return true;
            }
            hi++;
        }
        return false;
    }
    public static boolean isZero(int [] freq){
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}