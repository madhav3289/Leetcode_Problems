class Solution {
    public int minimumOperations(int[] nums) {
        int count=0;
        for(int i:nums){
            int opr=Math.min(i%3,3-i%3);
            count+=opr;
        }
        return count;       
    }
}