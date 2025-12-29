class Solution {
    public int subsetXORSum(int[] nums) {
        result=0;
        helper(nums,new ArrayList<>(),0);
        return result;
    }
    static int result=0;
    public static void helper(int [] nums,List<Integer> temp,int idx){
        int xor=0;
        for(int i=0;i<temp.size();i++){
            xor=temp.get(i)^xor;
        }
        result+=xor;
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            helper(nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}