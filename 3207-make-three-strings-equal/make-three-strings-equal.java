class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int minLen=Math.min(s1.length(),Math.min(s2.length(),s3.length()));
        int i=0;
        boolean isValid=true;
        while(isValid && i<minLen){
            isValid=(s1.charAt(i)==s2.charAt(i) && s2.charAt(i)==s3.charAt(i));
            if(isValid){
                i++;
            }
        }
        if(i==0){
            return -1;
        }
        return (s1.length()+s2.length()+s3.length()-3*i);
    }
}