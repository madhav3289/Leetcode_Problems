class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int [] res=new int[n];
        for(int i=0;i<n;i++){
            int num=nums.get(i);
            int ans=-1;
            for(int j=1;j<num;j++){
                if((j | j+1) == num){
                    ans=j;
                    break;
                }
            }
            res[i]=ans;
        }
        return res;
    }
}