class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> list=new ArrayList<>();
        for(int [] temp:buildings){
            int st=temp[0];
            int ed=temp[1];
            int ht=temp[2];

            list.add(new int[]{st,ht,1});       // 1 >> starting 
            list.add(new int[]{ed,ht,0});       // 0 >> ending
        }

        // sort by starting point
        Collections.sort(list,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            if(a[1]!=b[1]){
                return b[1]-a[1];
            }
            return b[2]-a[2];
        });

        // create a treemap
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,1);

        int pMax=0;

        List<List<Integer>> result=new ArrayList<>();

        int i=0;
        while(i<list.size()){
            int x=list.get(i)[0];

            while(i<list.size() && list.get(i)[0]==x){
                int y=list.get(i)[1];
                int flag=list.get(i)[2];

                // if it is starting point add to queue
                if(flag==1){
                    map.put(y,map.getOrDefault(y,0)+1);
                }
                // if it is ending point remove from queue
                else{
                    int c=map.get(y);
                    if(c==1){
                        map.remove(y);
                    }
                    else{
                        map.put(y,c-1);
                    }
                }
                i++;
            }            

            // find the current max
            int cMax=map.lastKey();

            // new maximum is found add to the result and update new max;
            if(cMax!=pMax){
                result.add(new ArrayList<>(List.of(x,cMax)));
                pMax=cMax;      // updated max;
            }
        }
        return result;
    }
}