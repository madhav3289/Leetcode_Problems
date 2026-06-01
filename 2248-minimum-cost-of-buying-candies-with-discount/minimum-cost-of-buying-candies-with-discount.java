class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        if(n==1){
            return cost[0];
        }
        if(n==2){
            return cost[0]+cost[1];
        }
        Arrays.sort(cost);

        int totalSum=0;
        int hi=n-1;
        while(hi>=0){
            totalSum+=cost[hi];
            totalSum+=((hi-1)>=0)?cost[hi-1]:0;
            hi-=3;
        }
        return totalSum;
    }
}