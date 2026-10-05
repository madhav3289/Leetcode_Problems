class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(stones[i],i);
        }
        Boolean [][] dp=new Boolean[2001][2001];
        return helper(stones,0,0,dp);
    }
    HashMap<Integer,Integer> map;

    public boolean helper(int [] stones,int curr_Idx,int prev_Jump,Boolean [][] dp){
        if(curr_Idx==stones.length-1){
            return true;
        }
        if(dp[curr_Idx][prev_Jump]!=null){
            return dp[curr_Idx][prev_Jump];
        }
        boolean result=false;
        for(int i=prev_Jump-1;i<=prev_Jump+1;i++){
            if(i>0){
                int next_Stone=stones[curr_Idx]+i;
                if(map.containsKey(next_Stone)){
                    result=result||helper(stones,map.get(next_Stone),i,dp);
                }
            }
        }
        return dp[curr_Idx][prev_Jump]=result;
    }
}