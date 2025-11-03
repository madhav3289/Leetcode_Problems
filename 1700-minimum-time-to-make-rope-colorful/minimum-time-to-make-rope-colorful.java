class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int minTime=0;
        char prevChar=colors.charAt(0);
        int prevVal=neededTime[0];
        for(int i=1;i<n;i++){
            char currChar=colors.charAt(i);
            int currVal=neededTime[i];
            if(currChar==prevChar){
                if(prevVal<=currVal){
                    minTime+=prevVal;
                    prevVal=currVal;
                }
                else{
                    minTime+=currVal;
                }
            }
            else{
                prevChar=currChar;
                prevVal=currVal;
            }
        }
        return minTime;
    }
}