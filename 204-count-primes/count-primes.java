class Solution {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        boolean [] visited=new boolean[n];
        Arrays.fill(visited,true);
        visited[0]=false;
        visited[1]=false;
        for(int i=2;i*i<n;i++){
            if(visited[i]){
                for(int j=i*i;j<n;j+=i){
                    visited[j]=false;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]){
                count++;
            }
        }
        return count;
    }
}