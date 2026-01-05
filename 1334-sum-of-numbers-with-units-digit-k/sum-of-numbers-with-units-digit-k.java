class Solution {
    public int minimumNumbers(int num, int k) {
        if(num==0){
            return 0;
        }
        if(k==0){
            return (num%10==0)?1:-1;
        }
        if(num<k){
            return -1;
        }
        List<Integer> list=new ArrayList<>();
        int start=k;
        while(start<=num){
            list.add(start);
            start+=10;
        }
        if(list.get(list.size()-1)==num){
            return 1;
        }
        // let n=136 & k=7 so list -> {7,17,27,37,47,57,67,77,87,97,107,117,127}
        // now find the size of smallest set where sum==n
        int [][] dp=new int[list.size()][num+1];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        int res=helper(list,num,0,dp);
        return (res==99999)?-1:res;
    }
    public static int helper(List<Integer> list,int num,int idx,int [][] dp){
        if(num==0){
            return 0;
        }
        if(idx>=list.size() || num<0){
            return 99999;
        }
        if(dp[idx][num]!=-1){
            return dp[idx][num];
        }
        int take=99999;
        int a=helper(list,num-list.get(idx),idx,dp);
        if(a!=99999){
            take=1+a;
        }
        int skip=helper(list,num,idx+1,dp);
        return dp[idx][num]=Math.min(take,skip);
    }
}