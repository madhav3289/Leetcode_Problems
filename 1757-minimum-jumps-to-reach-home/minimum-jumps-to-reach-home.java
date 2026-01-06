class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> forb=new HashSet<>();
        for(int num:forbidden){
            forb.add(num);
        }
        int limit=6000;
        return BFS(a,b,x,forb,limit);
    }
    public static int BFS(int a,int b,int x,HashSet<Integer> forb,int limit){
        HashSet<String> isPresent=new HashSet<>();
        // isPresent.add(0+"-"+1);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,true));
        while(!q.isEmpty()){
            // remove
            Pair e=q.poll();
            int pos=e.pos;
            int step=e.steps;
            int jump=(e.canJump)?1:0;
            // ignore
            if(isPresent.contains(pos+"-"+jump)){
                continue;
            }
            // mark visited
            isPresent.add(pos+"-"+jump);
            // self-work(if we reach the last index return the steps)
            if(pos==x){
                return step;
            }
            // add neighbouring(a and b)
            int newPos=pos+a;
            if(newPos<=limit && !forb.contains(newPos)){
                q.add(new Pair(newPos,step+1,true));
            }
            newPos=pos-b;
            if(newPos>=0 && !forb.contains(newPos) && jump!=0){
                q.add(new Pair(newPos,step+1,false));
            }
        }
        return -1;
    }
    static class Pair{
        int pos;
        int steps;
        boolean canJump;
        Pair(int pos,int steps,boolean canJump){
            this.pos=pos;
            this.steps=steps;
            this.canJump=canJump;
        }
    }
}