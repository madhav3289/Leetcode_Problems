class Solution {
    public int minArrivalsToDiscard(int[] nums, int w, int m) {
        // >> check if the size is withing the limit
        // >> if yes
            // check if the occurence of that element is less than m times or not
            // if yes, add it
            // else discard it and add that element to set 

        // >> if window length exceeds 
            // we need to remove the last package 
            // but make sure we only decrease it occurence if we have include that earlier
            // (means it should not be present on set >> discarded earlier)

        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        int discarded=0;    // count of discard
        int lo=0,hi=0;
        while(hi<n){
            int e=nums[hi];
            if(hi-lo+1<=w){
                if(map.containsKey(e)){
                    if(map.get(e)+1>m){
                        set.add(hi);    // to know in future if we have discarded this idx
                        discarded++;    // count of discarded increase by 1
                    }
                    else{
                        map.put(e,map.get(e)+1);
                    }
                }
                else{
                    map.put(e,1);
                }
            }
            else{
                if(!set.contains(lo)){
                    map.put(nums[lo],map.get(nums[lo])-1);
                    if(map.get(nums[lo])==0){
                        map.remove(nums[lo]);
                    }
                }
                lo++;
                if(map.containsKey(e)){
                    if(map.get(e)+1>m){
                        set.add(hi);    
                        discarded++;
                    }
                    else{
                        map.put(e,map.get(e)+1);
                    }
                }
                else{
                    map.put(e,1);
                }
            }
            hi++;
        }
        return discarded;
    }
}