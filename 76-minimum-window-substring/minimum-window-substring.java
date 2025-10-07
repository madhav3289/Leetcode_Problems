class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int [] freq=new int[256];
        for(int i=0;i<m;i++){
            freq[t.charAt(i)-'A']++;
        }
        int lo=0,hi=0;
        int count=m;
        String ans="";
        while(hi<n){
            if(freq[s.charAt(hi)-'A']>0){
                count--;
            }
            freq[s.charAt(hi)-'A']--;
            while(count==0){
                if(ans.length()==0){
                    ans=s.substring(lo,hi+1);
                }
                if(ans.length()>hi-lo+1){
                    ans=s.substring(lo,hi+1);
                }
                freq[s.charAt(lo)-'A']++;
                if(freq[s.charAt(lo)-'A']>0){
                    count++;
                }
                lo++;
            }
            hi++;
        }
        return ans;
    }
}