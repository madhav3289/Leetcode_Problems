class Solution {
    public int findJudge(int n, int[][] trust) {
        int m=trust.length;
        int [] prefix1=new int[n+1];
        for(int i=0;i<m;i++){
            int st=trust[i][0];
            prefix1[st]++;
        }
        int [] prefix2=new int[n+1];
        for(int i=0;i<m;i++){
            int ed=trust[i][1];
            prefix2[ed]++;
        }
        for(int i=1;i<=n;i++){
            if(prefix1[i]==0 && prefix2[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}