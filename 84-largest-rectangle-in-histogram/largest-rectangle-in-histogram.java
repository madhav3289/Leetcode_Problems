class Solution {
    public int largestRectangleArea(int[] nums) {
        int [] nse=nextSmaller(nums);
        int [] pse=prevSmaller(nums);
        int max=0;
        for(int i=0;i<nums.length;i++){
            int area=(nse[i]-pse[i]-1)*nums[i];
            max=Math.max(area,max);
        }
        return max;
    }
    public static int [] nextSmaller(int [] nums){
        int [] nse=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            nse[i]=(st.isEmpty())?nums.length:st.peek();
            st.push(i);
        }
        return nse;
    }
    public static int [] prevSmaller(int [] nums){
        int [] pse=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            pse[i]=(!st.isEmpty())?st.peek():-1;
            st.push(i);
        }
        return pse;
    }
}