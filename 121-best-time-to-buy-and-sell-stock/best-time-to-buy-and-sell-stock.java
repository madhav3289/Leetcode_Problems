class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxP=0;
        int buy=prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]<buy){
                buy=prices[i];
            }
            maxP=Math.max(maxP,prices[i]-buy);
        }
        return maxP;
    }
}