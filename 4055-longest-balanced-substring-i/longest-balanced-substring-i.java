class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int ans=0;
        // check every substring
        for(int i=0;i<n;i++){
            int k=0;    // to count distint characters
            int max=0;  // to store maximum frequency of character
            // store the frequency of every character
            int [] freq=new int[26];
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                freq[ch-'a']++; // increase frequency by 1
                if(freq[ch-'a']==1){
                    k++;    // if frequency is 1, means its a new character
                }
                max=Math.max(max,freq[ch-'a']); // store the maximum count a character appears
                // For a balanced substring of length len with k distinct characters, each character appears exactly L / k times. Hence, max*k==length  must hold true for any balanced substring.
                if(max*k==j-i+1){  
                    ans=Math.max(ans,j-i+1);    // store the maximum answer
                }

            }
        }
        return ans;
    }
}