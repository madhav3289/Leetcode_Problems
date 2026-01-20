class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] nge=nextGreater(nums2);
        // [3,4,-1,-1]
        int [] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res[i]=nge[nums1[i]];
        }
        return res;
    }
    public static int [] nextGreater(int [] nums){
        int n=nums.length;
        int [] nge=new int[10000+1];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>=st.peek()){
                st.pop();
            }
            nge[nums[i]]=(!st.isEmpty()?st.peek():-1);
            st.push(nums[i]);
        }
        return nge;
    }
}