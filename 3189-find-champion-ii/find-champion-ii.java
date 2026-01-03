class Solution {
    public int findChampion(int n, int[][] edges) {
        // comput the indegree of every node
        int [] inDegree=new int[n];
        for(int [] edge:edges){
            inDegree[edge[1]]++;
        }
        // count the nodes with indegree 0 and store that node..
        int count=0;
        int node=-1;
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                node=i;
                count++;
            }
        }
        // if there is a single node with indegree 0 means there is only one champion else, there are multiple champions which is not possible so return -1;
        return (count>1)?-1:node;
    }
}