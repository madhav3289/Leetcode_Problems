class Solution {
    static int n;
    static int m;
    public int maxSideLength(int[][] mat, int threshold) {
        m = mat.length;
        n = mat[0].length;
        int res = 0;
        for(int r=0; r<m; ++r){
            int tempR = 0;
            for(int c=0; c<n; ++c){
                tempR += mat[r][c];
                mat[r][c] = (r > 0 ? mat[r-1][c] : 0) + tempR;
                if(r-res >= 0 && c-res>=0 && threshold >= mat[r][c] -
                (r-res-1 >= 0 ? mat[r-res-1][c] : 0) - 
                (c-res-1 >= 0 ? mat[r][c-res-1] : 0) + 
                (c-res-1 >= 0 && r-res-1 >= 0 ? mat[r-res-1][c-res-1] : 0)){
                    ++res;
                }
            }
        }
        return res;
    }
}