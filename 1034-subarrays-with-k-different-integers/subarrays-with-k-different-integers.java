class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countArray(nums,k)-countArray(nums,k-1);
    }
    public static int countArray(int [] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int lo=0,hi=0;
        int count=0;
        while(hi<nums.length){
            map.put(nums[hi],map.getOrDefault(nums[hi],0)+1);
            while(map.size()>k){
                map.put(nums[lo],map.get(nums[lo])-1);
                if(map.get(nums[lo])==0){
                    map.remove(nums[lo]);
                }
                lo++;
            }
            count+=(hi-lo+1);
            hi++;
        }
        return count;
    }
}