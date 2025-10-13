class Solution {
    public int countArrangement(int n) {
        boolean [] isUsed=new boolean[n+1];
        return helper(n,isUsed,1);
    }
    public static int helper(int n,boolean [] isUsed,int num){
        if(num>n){
            return 1;
        }
        
        int count=0;
        for(int i=1;i<=n;i++){
            if(!isUsed[i] && (num%i==0 || i%num==0)){
                isUsed[i]=true;
                count+=helper(n,isUsed,num+1);
                isUsed[i]=false;
            }
        }
        return count;
    }
}