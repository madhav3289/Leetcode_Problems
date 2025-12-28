class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long val1=0;
        long val2=0;
        String newText=pattern.charAt(0)+text;
        val1=countSubSequence(newText,pattern);

        newText=text+pattern.charAt(1);
        val2=countSubSequence(newText,pattern);

        return Math.max(val1,val2);
    }
    public static long countSubSequence(String text,String pattern){
        char c1=pattern.charAt(0);
        char c2=pattern.charAt(1);
        long count=0;
        long res=0;
        for(int i=0;i<text.length();i++){
            if(pattern.charAt(0)!=pattern.charAt(1)){
                if(text.charAt(i)==c1){
                    count++;
                }
                else if(text.charAt(i)==c2){
                    res+=count;
                }
            }
            else{
                if(text.charAt(i)==c1){
                    count++;
                }
            }
        }
        return (c1==c2)?(count*(count-1)/2):res;
    }
}