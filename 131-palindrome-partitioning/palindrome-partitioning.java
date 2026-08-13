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
            if(isPalindrome(s,idx,i)){
                temp.add(s.substring(idx,i+1));
                helper(s,i+1,res,temp);
                temp.remove(temp.size()-1);
            }
        }
        
    }
    public static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}