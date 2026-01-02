class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length;
        long [] edgeScore=new long[n];
        for(int i=0;i<n;i++){
            int edge=edges[i];
            edgeScore[edge]+=i;
        }
        int maxEdge=0;
        long maxValue=edgeScore[0];
        for(int i=1;i<n;i++){
            if(edgeScore[i]>maxValue){
                maxValue=edgeScore[i];
                maxEdge=i;
            }
        }
        return maxEdge;
    }
}