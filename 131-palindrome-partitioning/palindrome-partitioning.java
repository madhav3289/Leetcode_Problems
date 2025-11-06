class Solution {
    static List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        helper(s,new ArrayList<>(),0);
        return res;
    }
    public static void helper(String s,List<String> temp,int idx){
        if(idx==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s.substring(idx,i+1))){
                temp.add(s.substring(idx,i+1));
                helper(s,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int lo=0;
        int hi=s.length()-1;
        while(lo<hi){
            if(s.charAt(lo)!=s.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}