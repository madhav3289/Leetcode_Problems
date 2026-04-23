class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        helper(k,n,list,new ArrayList<>(),1);
        return list;
    }
    public static void helper(int k,int n,List<List<Integer>> list,List<Integer> temp,int s){
        if(n==0 && temp.size()==k){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(n<0 || temp.size()>k){
            return;
        }
        for(int i=s;i<10;i++){
            temp.add(i);
            helper(k,n-i,list,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}