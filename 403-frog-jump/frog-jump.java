class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if(stones[1]!=1){
            return false;
        }
        map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(stones[i],i);
        }
        Boolean [][] dp=new Boolean[2001][2001];
        return helper(n,stones,0,0,dp);
    }
    HashMap<Integer,Integer> map;

    public boolean helper(int n,int [] stones,int curIdx,int prevJump,Boolean [][] dp){
        if(curIdx==n-1){
            return true;
        }
        if(dp[curIdx][prevJump]!=null){
            return dp[curIdx][prevJump];
        }
        boolean result=false;
        for(int i=prevJump-1;i<=prevJump+1;i++){
            if(i>0){
                int nextSt=stones[curIdx]+i;
                if(map.containsKey(nextSt)){
                    result=result||helper(n,stones,map.get(nextSt),i,dp);
                }
            }
        }

        return dp[curIdx][prevJump]=result;
    }
}