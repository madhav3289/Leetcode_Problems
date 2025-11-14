class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int [][] diff=new int[n][n];
        for(int [] q:queries){
            // [1,1,2,2]
            // rowStart=1,rowEnd=2
            // colStart=1,colEnd=2;
            int rS=q[0],rE=q[2];
            int cS=q[1],cE=q[3];
            for(int i=rS;i<=rE;i++){
                diff[i][cS]+=1;
                if(cE+1<n){
                    diff[i][cE+1]-=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            int st=0;
            for(int j=0;j<n;j++){
                diff[i][j]=diff[i][j]+st;
                st=diff[i][j];
            }
        }
        return diff;
    }
}