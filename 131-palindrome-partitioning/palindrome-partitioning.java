class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        helper(s,res,new ArrayList<>(),0);
        return res;
    }
    public static void helper(String s,List<List<String>> res,List<String> temp,int idx){
        if(idx>s.length()){
            return;
        }
        if(idx==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<s.length();i++){
            String sub=s.substring(idx,i+1);
            if(isPalindrome(sub)){
                temp.add(sub);
                helper(s,res,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int lo=0,hi=s.length()-1;
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