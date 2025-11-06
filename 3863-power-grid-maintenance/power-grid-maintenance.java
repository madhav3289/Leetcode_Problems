class Solution {
    // abdcvhvcverfvbejcbfjkewbnofnl
     static class DSU {
        int[] p;
        int[] r;
        DSU(int n){ p = new int[n+1]; r = new int[n+1]; for(int i=1;i<=n;i++) p[i]=i; }
        int find(int x){ return p[x]==x?x:(p[x]=find(p[x])); }
        void union(int a,int b){
            a=find(a); b=find(b);
            if(a==b) return;
            if(r[a]<r[b]) p[a]=b;
            else if(r[b]<r[a]) p[b]=a;
            else { p[b]=a; r[a]++; }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);
        for (int[] e : connections) dsu.union(e[0], e[1]);
        Map<Integer, TreeSet<Integer>> comp = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int r = dsu.find(i);
            comp.computeIfAbsent(r, k -> new TreeSet<>()).add(i);
        }
        boolean[] offline = new boolean[c + 1];
        int type1Count = 0;
        for (int[] q : queries) if (q[0] == 1) type1Count++;
        int[] ans = new int[type1Count];
        int idx = 0;
        for (int[] q : queries) {
            int t = q[0], x = q[1];
            if (t == 2) {
                if (!offline[x]) {
                    offline[x] = true;
                    int r = dsu.find(x);
                    TreeSet<Integer> ts = comp.get(r);
                    if (ts != null) ts.remove(x);
                }
            } else {
                if (!offline[x]) ans[idx++] = x;
                else {
                    int r = dsu.find(x);
                    TreeSet<Integer> ts = comp.get(r);
                    ans[idx++] = (ts == null || ts.isEmpty()) ? -1 : ts.first();
                }
            }
        }
        return ans;
    }
}