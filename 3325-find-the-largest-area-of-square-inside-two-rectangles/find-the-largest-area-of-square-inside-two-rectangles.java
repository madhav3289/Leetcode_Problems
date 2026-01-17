class Solution {
    public long largestSquareArea(int[][] bottom, int[][] top) {
        int n=bottom.length;
        long maxSide=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int bt1=Math.max(bottom[i][0],bottom[j][0]);
                int tp1=Math.min(top[i][0],top[j][0]);
                int wd=tp1-bt1;

                int bt2=Math.max(bottom[i][1],bottom[j][1]);
                int tp2=Math.min(top[i][1],top[j][1]);
                int ht=tp2-bt2;

                int side=Math.min(wd,ht);
                maxSide=Math.max(maxSide,side);
            }
        }
        return maxSide*maxSide;
    }
}