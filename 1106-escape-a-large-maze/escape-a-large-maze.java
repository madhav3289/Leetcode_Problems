class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Pair> block=new HashSet<>();
        for(int [] arr:blocked){
            block.add(new Pair(arr[0],arr[1]));
        }
        // now use BFS or DFS to find if there exists a path from target to root
        // **BFS is more suitable to find the shortest path compared to DFS**
        return BFS(source,target,block) && BFS(target,source,block);
    }
    static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return row == p.row && col == p.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    static int bound=1_000_000;
    static int limit=20000;
    public static boolean BFS(int [] source,int [] target,Set<Pair> block){
        Queue<Pair> q=new LinkedList<>();
        Set<Pair> set=new HashSet<>();

        q.add(new Pair(source[0],source[1]));
        set.add(new Pair(source[0],source[1]));

        int [][] dir={{0,-1},{-1,0},{0,1},{1,0}};
        // {west,north,east,south}
        while(!q.isEmpty()){
            // remove
            Pair p=q.poll();
            // ignore
            // mark visited
            // self work
            if(p.row==target[0] && p.col==target[1]){
                return true;
            }
            // add neighbours
            for(int i=0;i<4;i++){
                int c_row=p.row+dir[i][0];
                int c_col=p.col+dir[i][1];
                if(c_row<0 || c_col<0 || c_row>=bound || c_col>=bound){
                    continue;
                }
                Pair t=new Pair(c_row,c_col);
                if(block.contains(t) || set.contains(t)){
                    continue;
                }
                set.add(t);
                q.add(t);
            }
            if(set.size()>limit){
                return true;
            }
        }
        return false;
    }
}