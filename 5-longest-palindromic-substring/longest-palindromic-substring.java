class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        String str="";
        for(int i=0;i<s.length()-1;i++){
            String odd=expand(s,i,i);
            String even=expand(s,i,i+1);

            if(odd.length()>str.length()){
                str=odd;
            }
            if(even.length()>str.length()){
                str=even;
            }
        }
        return str;
    }
    public static String expand(String s,int lo,int hi){
        while(lo>=0 && hi<s.length() && s.charAt(lo)==s.charAt(hi)){
            lo--;
            hi++;
        }
        return s.substring(lo+1,hi);
    }
}