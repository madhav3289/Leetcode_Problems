class Solution {
    public int countTriples(int n) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<=n;i++){
            int sq=i*i;
            set.add(sq);
        }
        int count=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int val=i*i+j*j;
                if(set.contains(val)){
                    count++;
                }
            }
        }
        return count;
    }
}