class Solution {
    public class Pair{
        int value;
        int index;
        Pair(int value,int index){
            this.value=value;
            this.index=index;
        }
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n=nums.length;
        TreeSet<Pair> set=new TreeSet<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                if(a.value==b.value){
                    return a.index-b.index;
                }
                return a.value-b.value;
            }
        });
        for(int i=0;i<n;i++){
            Pair p=new Pair(nums[i],i);
            Pair floor=set.floor(p);
            Pair ceil=set.ceiling(p);
            if(floor!=null){
                int diff=Math.abs(floor.index-i);
                int vald=Math.abs(floor.value-nums[i]);
                if(diff<=indexDiff && vald<=valueDiff){
                    return true;
                }
            }
            if(ceil!=null){
                int diff=Math.abs(ceil.index-i);
                int vald=Math.abs(ceil.value-nums[i]);
                if(diff<=indexDiff && vald<=valueDiff){
                    return true;
                }
            }
            set.add(p);
            if(i>=indexDiff){
                set.remove(new Pair(nums[i-indexDiff],i-indexDiff));
            }
        }
        return false;
    }
}