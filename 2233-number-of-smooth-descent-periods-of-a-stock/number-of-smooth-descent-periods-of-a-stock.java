class Solution {
    public long getDescentPeriods(int[] prices) {
        long count=1;
        long c=1;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]-prices[i]==1){
                c++;
            }
            else{
                c=1;
            }
            count+=c;
        }
        return count;
    }
}