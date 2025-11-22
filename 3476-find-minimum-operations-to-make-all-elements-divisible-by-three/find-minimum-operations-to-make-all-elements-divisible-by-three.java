class Solution {
    public int minimumOperations(int[] nums) {
        int count=0;
        for(int i:nums){
            count+=Math.min(i%3,3-i%3);
        }
        return count;       
    }
}