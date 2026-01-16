class Solution {
    public String largestMerge(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        String res="";
        int i=0,j=0;
        while(i<n && j<m){
            if(s1.substring(i).compareTo(s2.substring(j))>0){
                res+=s1.charAt(i);
                i++;
            }
            else{
                res+=s2.charAt(j);
                j++;
            }
        }
        res+=s1.substring(i);
        res+=s2.substring(j);
        return res;
    }
}