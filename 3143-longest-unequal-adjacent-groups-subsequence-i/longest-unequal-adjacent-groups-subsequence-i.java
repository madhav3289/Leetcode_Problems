class Solution {
    static List<String> res;
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        res=new ArrayList<>();
        helper(words,groups,0,-1,new ArrayList<>());
        return res;
    }
    public static void helper(String [] words,int [] groups,int idx,int prevIdx,List<String> temp){
        if(idx>=words.length){
            if(temp.size()>res.size()){
                res=new ArrayList<>(temp);
            }
            return;
        }
        if(prevIdx!=-1 && groups[prevIdx]==groups[idx]){
            return;
        }
        temp.add(words[idx]);
        helper(words,groups,idx+1,idx,temp);
        temp.remove(temp.size()-1);
        helper(words,groups,idx+1,prevIdx,temp);
        return;
    }
}