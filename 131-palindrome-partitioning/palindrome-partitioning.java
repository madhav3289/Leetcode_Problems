class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        helper(s,0,res,new ArrayList<>());
        return res;
    }
    public static void helper(String s,int idx,List<List<String>> res,List<String> temp){
        if(idx>=s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s.substring(idx,i+1))){
                temp.add(s.substring(idx,i+1));
                helper(s,i+1,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int lo=0;
        int hi=s.length()-1;
        while(lo<=hi){
            if(s.charAt(lo)!=s.charAt(hi)){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}