class Solution {
    static HashMap<Integer,List<Integer>> mapRow;
    static HashMap<Integer,List<Integer>> mapCol;
    public int countCoveredBuildings(int n, int[][] grid) {
        int m=grid.length;
        // Arrays.sort(grid,(a,b)->{
        //     if(a[0]==b[0]){
        //         return a[1]-b[1];
        //     }
        //     return a[0]-b[0];
        // });
        mapRow=new HashMap<>();
        mapCol=new HashMap<>();
        for(int [] arr:grid){
            if(mapRow.containsKey(arr[0])){
                mapRow.get(arr[0]).add(arr[1]);
            }
            else{
                mapRow.put(arr[0],new ArrayList<>());
                mapRow.get(arr[0]).add(arr[1]);
            }

            if(mapCol.containsKey(arr[1])){
                mapCol.get(arr[1]).add(arr[0]);
            }
            else{
                mapCol.put(arr[1],new ArrayList<>());
                mapCol.get(arr[1]).add(arr[0]);
            }
        }
        for(int key:mapRow.keySet()){
            Collections.sort(mapRow.get(key));
        }
        for(int key:mapCol.keySet()){
            Collections.sort(mapCol.get(key));
        }
        int count=0;
        for(int [] arr:grid){
            if(isPresent(arr)){
                count++;
            }
        }
        return count;
    }
    public static boolean isPresent(int [] arr){
        boolean left=false;
        boolean right=false;
        boolean up=false;
        boolean down=false;
        if(mapRow.containsKey(arr[0])){
            List<Integer> temp=mapRow.get(arr[0]);
            if(temp.get(0)<arr[1]){
                left=true;
            }
            if(temp.get(temp.size()-1)>arr[1]){
                right=true;
            }
        }
        if(mapCol.containsKey(arr[1])){
            List<Integer> temp=mapCol.get(arr[1]);
            if(temp.get(0)<arr[0]){
                up=true;
            }
            if(temp.get(temp.size()-1)>arr[0]){
                down=true;
            }
        }
        return left&&right&&up&&down;
    }
}