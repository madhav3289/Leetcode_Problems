class Solution {
    public int totalSteps(int[] nums) {
        int n=nums.length;
        Stack<int[]> st=new Stack<>();
        int maxOp=0;
        for(int i=n-1;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && nums[i]>nums[st.peek()[0]]){
                count=Math.max(count+1,st.peek()[1]);
                st.pop();
            }
            maxOp=Math.max(maxOp,count);
            st.push(new int[]{i,count});
        }
        return maxOp;
    }
}