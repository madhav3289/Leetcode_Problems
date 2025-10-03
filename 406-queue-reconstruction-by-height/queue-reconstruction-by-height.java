class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n=people.length;
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int idx=people[i][1];
            ans.add(idx,people[i]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}