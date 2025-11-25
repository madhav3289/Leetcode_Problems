class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0){
            return -1;
        }
        boolean [] isUsed=new boolean[k];
        int num=0;
        int ans=0;
        while(true){
            ans++;
            num=(num*10+1)%k;
            if(num==0){
                return ans;
            }
            if(isUsed[num]){
                return -1;
            }
            isUsed[num]=true;
        }
    }
}