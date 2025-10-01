class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int [][] arr=new int[n][m];
        for(int i=0;i<m;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(matrix[j][i]=='1'){
                    count++;
                }
                else{
                    count=0;
                }
                arr[j][i]=count;
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,largestRectangle(arr[i]));
        }
        return max;
    }
    public static int largestRectangle(int[] nums) {
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