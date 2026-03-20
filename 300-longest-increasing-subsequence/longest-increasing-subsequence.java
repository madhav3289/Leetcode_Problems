class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int val=nums[i];
            if(list.isEmpty() || list.get(list.size()-1)<val){
                list.add(val);
            }
            else{
                int idx=binarySearch(list,val);
                list.set(idx,val);
            }
        }
        return list.size();
    }
    public static int binarySearch(List<Integer> list,int val){
        int lo=0;
        int hi=list.size()-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(val<=list.get(mid)){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return lo;
    }
}