class Solution {
    public int[] countRectangles(int[][] rect, int[][] points) {
        // >> Brute Force <<

        // int n=rect.length;
        // int m=point.length;
        // int [] ans=new int[m];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(point[i][0]<=rect[j][0] && point[i][1]<=rect[j][1]){
        //             ans[i]++;
        //         }
        //     }
        // }
        // return ans;

        // >> Optimal <<

        // [1,2],[2,3],[2,5],[3,2],[3,7],[4,3],[9,1]
        // [1,4],[2,1],[4,3]

        // >> [2,6,1]

        int n=rect.length;
        int m=points.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int x=rect[i][0];
            int y=rect[i][1];
            if(map.containsKey(y)){
                map.get(y).add(x);
            }
            else{
                map.put((y),new ArrayList<>());
                map.get(y).add(x);
            }
        }
        for(int key:map.keySet()){
            Collections.sort(map.get(key));
        }
        int [] ans=new int[m];
        for(int i=0;i<m;i++){
            int x=points[i][0];
            int y=points[i][1];
            int total=0;
            for(int j=y;j<=100;j++){
                if(map.containsKey(j)){
                    total+=map.get(j).size()-binarySearch(map.get(j),x);
                }
            }
            ans[i]=total;
        }
        return ans;
    }
    public static int binarySearch(List<Integer> list,int num){
        int lo=0;
        int hi=list.size()-1;
        int ans=list.size();
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(list.get(mid)>=num){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}