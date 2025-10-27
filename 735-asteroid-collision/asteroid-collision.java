class Solution {
    public int[] asteroidCollision(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                st.push(nums[i]);
            }
            else{
                int num=Math.abs(nums[i]);
                while(!st.isEmpty() && st.peek()>0 && st.peek()<num){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==num){
                    st.pop();
                    continue;
                }
                if(!st.isEmpty() && st.peek()>num){
                    continue;
                }
                st.push(nums[i]);
            }
        }
        int len=st.size();
        int [] ans=new int[len];
        int idx=len-1;
        while(!st.isEmpty()){
            ans[idx--]=st.pop();
        }
        return ans;
    }
}