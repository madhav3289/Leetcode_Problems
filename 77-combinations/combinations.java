class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,n,k,1,new ArrayList<>());
        return ans;
    }
    public static void helper(List<List<Integer>> ans,int n,int k,int idx,List<Integer> temp){
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
        }
        if(temp.size()>k){
            return;
        }
        for(int i=idx;i<=n;i++){
            temp.add(i);
            helper(ans,n,k,i+1,temp);
            temp.remove(temp.size()-1);
        }
    }
}