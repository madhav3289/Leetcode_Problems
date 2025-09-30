class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int t=n*m;
        List<Integer> list=new ArrayList<>(); 
        int rs=0,cs=0;
        int re=n-1,ce=m-1;
        while(t>0){
            // rs cs->ce
            // rs++
            for(int i=cs;i<=ce && t-->0;i++){
                list.add(matrix[rs][i]);
            }
            rs++;

            // ce rs->re
            // ce--
            for(int i=rs;i<=re && t-->0;i++){
                list.add(matrix[i][ce]);
            }
            ce--;

            // re ce->cs
            // re--;
            for(int i=ce;i>=cs && t-->0;i--){
                list.add(matrix[re][i]);
            }
            re--;

            // cs re->rs
            // cs++;
            for(int i=re;i>=rs && t-->0;i--){
                list.add(matrix[i][cs]);
            }
            cs++;
        }
        return list;
    }
}