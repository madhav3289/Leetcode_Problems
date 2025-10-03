class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,target,ans,new ArrayList<>(),0);
        return ans;
    }
    public static void helper(int [] nums,int target,List<List<Integer>> ans,List<Integer> temp,int idx){
        if(target==0){
            if(!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }            
            return;
        }
        if(target<0){
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            helper(nums,target-nums[i],ans,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}