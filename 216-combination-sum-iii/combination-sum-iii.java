class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        helper(k,n,list,new ArrayList<>(),1,new boolean[10]);
        return list;
    }
    public static void helper(int k,int n,List<List<Integer>> list,List<Integer> temp,int s,boolean [] used){
        if(n<0 || temp.size()>k){
            return;
        }
        if(n==0 && temp.size()==k){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=s;i<10;i++){
            if(temp.size()==0 || (!used[i] && temp.get(temp.size()-1)<i)){
                used[i]=true;
                temp.add(i);
                helper(k,n-i,list,temp,s+1,used);
                temp.remove(temp.size()-1);
                used[i]=false;
            }
        }
    }
}