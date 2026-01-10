class Solution {
    public int[] avoidFlood(int[] nums) {
        int n=nums.length;
        // hashmap to store the lake and index
        HashMap<Integer,Integer> map=new HashMap<>();
        // min-heap to store the days with no rain
        TreeSet<Integer> set=new TreeSet<>((a,b)->a-b);
        // resultant array
        int [] result=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                set.add(i);
            }
            else{
                result[i]=-1;
                if(map.containsKey(nums[i])){
                    int index=map.get(nums[i]);
                    Integer day=set.ceiling(index+1);
                    if(day==null){
                        return new int[0];
                    }
                    set.remove(day);
                    result[day]=nums[i];
                }
                map.put(nums[i],i);
            }
        }
        for(int i=0;i<n;i++){
            if(result[i]==0){
                result[i]=1;
            }
        }
        return result;
    }
}