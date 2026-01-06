class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // int limit=6000;
        int limit=2000+2*b;
        HashSet<Integer> forb=new HashSet<>();
        // to keep a track of forbidden positions..
        for(int num:forbidden){
            forb.add(num);
            limit=Math.max(limit,num+2*b);
        }
        return BFS(a,b,x,forb,limit);
    }
    public static int BFS(int a,int b,int x,HashSet<Integer> forb,int limit){
        // hashset to keep a track of already visited positions..
        HashSet<String> isPresent=new HashSet<>();  

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,true));  // add the starting value with 0 as current position and 0 steps taken
        while(!q.isEmpty()){
            // remove from queue
            Pair e=q.poll();
            int pos=e.pos;
            int step=e.steps;
            int jump=(e.canJump)?1:0;
            // ignore if string is already present in set
            if(isPresent.contains(pos+"-"+jump)){
                continue;
            }
            // mark visited the current state
            isPresent.add(pos+"-"+jump);
            // self-work(if we reach the last index return the steps)
            if(pos==x){
                return step;
            }
            // add neighbours(forward a or backward b)
            // add element a forward
            int newPos=pos+a;
            if(newPos<=limit && !forb.contains(newPos)){
                q.add(new Pair(newPos,step+1,true));
            }
            // add element b backward (if possible)
            newPos=pos-b;
            if(newPos>=0 && !forb.contains(newPos) && jump!=0){
                q.add(new Pair(newPos,step+1,false));
            }
        }
        // return -1 if we can never reach the position x
        return -1;
    }
    // implement a pair class
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