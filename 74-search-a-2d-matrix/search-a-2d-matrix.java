class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int [] nums=new int[n*m];
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[idx++]=matrix[i][j];
            }
        }
        return BinarySearch(nums,target);
    }
    public static boolean BinarySearch(int [] nums,int target){
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return false;
    }
}