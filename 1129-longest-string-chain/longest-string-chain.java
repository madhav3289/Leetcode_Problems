class Solution {
    static HashMap<String,Integer> memo;
    public int longestStrChain(String[] words) {
        // sorting logic
        Arrays.sort(words,(a,b)->(a.length()-b.length()));
        memo=new HashMap<>();
        return helper(words,0,"");
    }
    public static int helper(String [] words,int idx,String prev){
        if(idx==words.length){
            return 0;
        }
        if(memo.containsKey(prev)){
            return memo.get(prev);
        }
        int inc=0,exc1=0,exc2=0;
        // if it is a valid chain then we have two choices either include that or not.
        if(prev.equals("") || isValidChain(prev,words[idx])){
            inc=1+helper(words,idx+1,words[idx]);
            exc1=helper(words,idx+1,prev);
        }
        // but if its not a valid string chain we just move to next index.
        else{
            exc2=helper(words,idx+1,prev);
        }
        int maxi=Math.max(inc,Math.max(exc1,exc2));
        memo.put(prev,maxi);
        return maxi;
    }
    public static boolean isValidChain(String word1,String word2){
        int n=word1.length();
        int m=word2.length();
        if(m!=n+1){
            return false;
        }
        int i=0,j=0;
        int count=0;
        while(i<n && j<m){
            if(word1.charAt(i)==word2.charAt(j)){
                i++;
                j++;
            }
            else{
                count++;
                j++;
                if(count>1){
                    return false;
                }
            } 
        }
        count+=(m-j);
        return (count==1);
    }
}