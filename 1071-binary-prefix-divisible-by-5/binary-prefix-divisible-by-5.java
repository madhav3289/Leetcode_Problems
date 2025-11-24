class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n=nums.length;
        List<Boolean> res=new ArrayList<>();
        int num=0;
        for(int i=0;i<n;i++){
            num=(num*2+nums[i])%5;
            res.add(num==0);
        }
        return res;
    }
}