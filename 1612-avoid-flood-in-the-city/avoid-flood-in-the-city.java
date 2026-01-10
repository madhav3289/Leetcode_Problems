class Solution {
    public int[] avoidFlood(int[] nums) {
        int n=nums.length;
        // hashmap to store the lake and index
        HashMap<Integer,Integer> map=new HashMap<>();
        // list to store the index of all zeros
        List<Integer> list=new ArrayList<>();
        // resultant array
        int [] result=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                list.add(i);
            }
            else{
                result[i]=-1;
                if(map.containsKey(nums[i])){
                    int index=map.get(nums[i]);
                    int val=binarySearch(index,list);
                    if(val==-1){
                        return new int[0];
                    }
                    int day=list.get(val);
                    list.remove(val);
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
    public static int binarySearch(int index,List<Integer> list){
        int lo=0;
        int hi=list.size()-1;
        int res=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(list.get(mid)>index){
                res=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return res;
    }
}