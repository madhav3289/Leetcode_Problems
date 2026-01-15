class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        Arrays.sort(vBars);
        int maxCols=1;
        int curr=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1){
                curr++;
            }
            else{
                curr=1;
            }
            maxCols=Math.max(curr,maxCols);
        }
        
        Arrays.sort(hBars);
        int maxRows=1;
        curr=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1){
                curr++;
            }
            else{
                curr=1;
            }
            maxRows=Math.max(curr,maxRows);
        }
        int len=Math.min(maxRows,maxCols)+1;
        return len*len;
    }
}