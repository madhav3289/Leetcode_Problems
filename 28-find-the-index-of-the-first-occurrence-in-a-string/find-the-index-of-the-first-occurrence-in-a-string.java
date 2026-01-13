class Solution {
    public int strStr(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int i=0;
        while(i<n){
            if(s1.charAt(i)==s2.charAt(0) && i+m-1<n && s1.substring(i,i+m).equals(s2)){
                return i;
            }
            i++;
        }
        return -1;
    }
}