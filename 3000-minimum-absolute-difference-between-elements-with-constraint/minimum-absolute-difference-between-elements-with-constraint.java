class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set=new TreeSet<>();
        int n=nums.size();
        if(x>n){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        for(int i=x;i<n;i++){
            set.add(nums.get(i-x));
            Integer ceil=set.ceiling(nums.get(i));
            Integer floor=set.floor(nums.get(i));
            if(ceil!=null){
                res=Math.min(res,Math.abs(nums.get(i)-ceil));
            }
            if(floor!=null){
                res=Math.min(res,Math.abs(nums.get(i)-floor));
            }
        }
        return res;
    }
}