class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;
        int idx=0;
        int curGas=0;
        for(int i=0;i<gas.length;i++){
            totalCost+=cost[i];
            totalGas+=gas[i];
            curGas+=gas[i]-cost[i];
            if(curGas<0){
                curGas=0;
                idx=i+1;
            }
        }
        if(totalGas<totalCost){
            return -1;
        }
        return idx;
    }
}