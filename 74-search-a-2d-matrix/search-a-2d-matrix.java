class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int lo=0;
        int hi=n-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(matrix[mid][0]<=target && matrix[mid][m-1]>=target){
                int l=0;
                int h=m-1;
                while(l<=h){
                    int md=l+(h-l)/2;
                    if(matrix[mid][md]<target){
                        l=md+1;
                    }
                    else if(matrix[mid][md]>target){
                        h=md-1;
                    }
                    else{
                        return true;
                    }
                }
                return false;
            }
            else if(matrix[mid][0]<target && matrix[mid][m-1]<target){
                lo=mid+1;
            }
            else if(matrix[mid][0]>target && matrix[mid][m-1]>target){
                hi=mid-1;
            }
        }
        return false;
    }
}