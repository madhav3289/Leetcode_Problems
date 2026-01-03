class Solution {
    public int findChampion(int n, int[][] edges) {
        int [] inDegree=new int[n];
        for(int [] edge:edges){
            inDegree[edge[1]]++;
        }
        int count=0;
        int node=-1;
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                node=i;
                count++;
            }
        }
        return (count>1)?-1:node;
    }
}