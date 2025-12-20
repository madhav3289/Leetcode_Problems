class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int len=cells.length;
        List<List<Integer>> list=new ArrayList<>();
        while(n-->0){
            int [] temp=new int[len];
            for(int i=1;i<len-1;i++){
                if(cells[i-1]==cells[i+1]) temp[i]=1;
                else temp[i]=0;
            }
            List<Integer> ar=new ArrayList<>();
            for(int t:temp){
                ar.add(t);
            }
            if(list.contains(ar)){
                int idx=list.indexOf(ar);
                return toArr(list.get(idx+(n%(list.size()-idx))));
            }
            else{
                list.add(ar);
            }
            cells=temp;
        }
        return cells;
    }
    public static int[] toArr(List<Integer> list){
        int [] arr=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    } 
}