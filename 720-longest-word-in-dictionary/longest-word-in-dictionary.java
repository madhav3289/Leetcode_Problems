class Solution {
    public String longestWord(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->a.compareTo(b));
        StringBuilder maxLen=new StringBuilder();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<n;i++){
            String cur=words[i];
            if(cur.length()==1 || set.contains(cur.substring(0,cur.length()-1))){
                set.add(cur);
                if(cur.length()>maxLen.length()){
                    maxLen.setLength(0);
                    maxLen.append(cur);
                }
            }
        }
        return maxLen.toString();
    }
}