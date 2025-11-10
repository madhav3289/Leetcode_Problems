class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int opr=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>=nums[i]){
                if(st.peek()>nums[i]){
                    opr++;
                }
                st.pop();
            }
            if(nums[i]!=0){
                st.push(nums[i]);
            }            
        }
        return opr+st.size();
    }
}