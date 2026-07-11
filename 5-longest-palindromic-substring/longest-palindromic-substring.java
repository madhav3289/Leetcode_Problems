class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        String res="";

        for(int i=0;i<n;i++){
            // expand from i+1
            if(i>=0 && i<n-1 && s.charAt(i)==s.charAt(i+1)){
                String temp=expand(s,i,i+1);
                if(temp.length()>res.length()){
                    res=temp;
                }
            }
            // expand from same index(i)
            String t1=expand(s,i,i);
            if(t1.length()>res.length()){
                res=t1;
            }
        }
        return res;
    }
    public static String expand(String s,int lo,int hi){
        int n=s.length();
        String res="";
        while(lo>=0 && hi<n && s.charAt(lo)==s.charAt(hi)){
            res=s.substring(lo,hi+1);
            lo--;
            hi++;
        }
        return res;
    }
}