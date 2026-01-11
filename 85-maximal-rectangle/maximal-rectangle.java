class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int [][] newMat=new int[n][m];
        for(int col=0;col<m;col++){
            int count=0;
            for(int row=0;row<n;row++){
                count=(matrix[row][col]=='1')?count+1:0;
                newMat[row][col]=count;
            }
        }
        int result=0;
        for(int [] nums:newMat){
            result=Math.max(result,largestHistogram(nums));
        }
        return result;
    }
    public static int largestHistogram(int [] nums){
        int [] nse=nextSmallerElement(nums);
        int [] pse=prevSmallerElement(nums);
        int maxArea=0;
        for(int i=0;i<nums.length;i++){
            int area=(nse[i]-pse[i]-1)*nums[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
    public static int[] nextSmallerElement(int [] nums){
        int n=nums.length;
        int [] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                st.pop();
            }
            nse[i]=(st.isEmpty())?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public static int[] prevSmallerElement(int [] nums){
        int n=nums.length;
        int [] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[i]<=nums[st.peek()]){
                st.pop();
            }
            pse[i]=(st.isEmpty())?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
}