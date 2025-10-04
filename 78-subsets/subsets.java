class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(ans,nums,0,new ArrayList<>());
        return ans;
    }
    public static void helper(List<List<Integer>> ans,int [] nums,int idx,List<Integer> temp){
        if(idx==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        helper(ans,nums,idx+1,temp);
        temp.remove(temp.size()-1);
        helper(ans,nums,idx+1,temp);
    }
}