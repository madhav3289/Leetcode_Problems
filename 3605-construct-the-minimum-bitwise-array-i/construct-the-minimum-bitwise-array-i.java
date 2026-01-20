class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int [] res=new int[n];
        for(int i=0;i<n;i++){
            int num=nums.get(i);
            if(num==2){
                res[i]=-1;
                continue;
            }
            int ans=-1;
            for(int j=1;j<32;j++){
                if((num & (1<<j))>0){
                    continue;
                }
                int prev=j-1;
                ans=(num^(1<<(j-1)));
                break;
            }
            res[i]=ans;
        }
        return res;
    }
}