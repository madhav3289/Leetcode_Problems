class Solution {
    public class Pair{
        int val;
        int idx;
        Pair(int val,int idx){
            this.val=val;
            this.idx=idx;
        }
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n=nums.length;
        TreeSet<Pair> set=new TreeSet<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                if(a.val==b.val){
                    return a.idx-b.idx;
                }
                return a.val-b.val;
            }
        });

        for(int i=0;i<n;i++){
            Pair temp=new Pair(nums[i],i);
            Pair g=set.floor(temp);
            Pair l=set.ceiling(temp);
            if(l!=null){
                int idf=Math.abs(i-l.idx);
                int vdf=Math.abs(nums[i]-l.val);
                if(idf<=indexDiff && vdf<=valueDiff){
                    return true;
                }
            }
            if(g!=null){
                int idf=Math.abs(i-g.idx);
                int vdf=Math.abs(nums[i]-g.val);
                if(idf<=indexDiff && vdf<=valueDiff){
                    return true;
                }
            }
            set.add(new Pair(nums[i],i));
            if(i>=indexDiff){
                set.remove(new Pair(nums[i-indexDiff],i-indexDiff));
            }
        }
        return false;
    }
}