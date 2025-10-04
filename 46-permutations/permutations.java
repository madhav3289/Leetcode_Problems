class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean [] used=new boolean[nums.length];
        helper(ans,nums,new ArrayList<>(),used);
        return ans;
    }
    public static void helper(List<List<Integer>> ans,int [] nums,List<Integer> temp,boolean [] used){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size()>nums.length){
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                temp.add(nums[i]);
                helper(ans,nums,temp,used);
                temp.remove(temp.size()-1);
                used[i]=false;
            }
        }
    }
}