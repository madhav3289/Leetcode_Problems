class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<points.length;i++){
            int num=points[i][1];
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        List<Long> l1=new ArrayList<>();
        List<Long> l2=new ArrayList<>();
        for(int i:hash.keySet()){
            int num=hash.get(i);
            if(num>1){
                long val=(num*1l*(num-1))/2;
                l1.add(val);
                l2.add(val);
            }
        }
        for(int i=l1.size()-2;i>=0;i--){
            l2.set(i,l2.get(i+1)+l2.get(i));
        }
        long ans=0;
        long mod=(long)1_000_000_007;
        for(int i=0;i<l1.size()-1;i++){
            ans=(ans+l1.get(i)*(l2.get(i+1)))%mod;
        }
        return (int)ans;
    }
}