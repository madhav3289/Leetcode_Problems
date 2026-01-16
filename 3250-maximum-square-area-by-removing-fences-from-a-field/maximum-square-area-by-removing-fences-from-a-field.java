class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        // create a list to store columns
        List<Integer> rows=new ArrayList<>();
        for(int i=0;i<hFences.length;i++){
            rows.add(hFences[i]);
        }
        rows.add(1);
        rows.add(m);

        // create a list to store columns
        List<Integer> cols=new ArrayList<>();
        for(int i=0;i<vFences.length;i++){
            cols.add(vFences[i]);
        }
        cols.add(1);
        cols.add(n);

        // store the diff of each pair of row in rowDiff set
        Set<Integer> rowDif=new HashSet<>();
        for(int i=0;i<rows.size();i++){
            for(int j=i+1;j<rows.size();j++){
                rowDif.add(Math.abs(rows.get(i)-rows.get(j)));
            }
        }

        // store the diff of each pair of col in colDiff set
        Set<Integer> colDif=new HashSet<>();
        for(int i=0;i<cols.size();i++){
            for(int j=i+1;j<cols.size();j++){
                colDif.add(Math.abs(cols.get(i)-cols.get(j)));
            }
        }

        // calculate the area of largest square
        long maxArea=0;
        for(int num:rowDif){
            if(colDif.contains(num)){
                maxArea=Math.max(maxArea,(long)num*num);
            }
        }
        int mod=1_000_000_007;
        // if exists return max%mod else return -1
        return (maxArea==0)?-1:(int)(maxArea%mod);
    }
}