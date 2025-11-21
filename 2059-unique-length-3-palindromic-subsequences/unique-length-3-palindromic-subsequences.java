class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        int [] first=new int[26];
        int [] last=new int[26];
        Arrays.fill(first,-1);
        Arrays.fill(last,-1);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(first[ch-'a']==-1){
                first[ch-'a']=i;
            }
            last[ch-'a']=i;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            boolean [] visited=new boolean[26];
            Arrays.fill(visited,false);
            int st=first[i];
            int ed=last[i];
            int count=0;
            for(int j=st+1;j<ed;j++){
                char ch=s.charAt(j);
                if(!visited[ch-'a']){
                    visited[ch-'a']=true;
                    count++;
                }
            }
            ans+=count;
        }
        return ans;
    }
}