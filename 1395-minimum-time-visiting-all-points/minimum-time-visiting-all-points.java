class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n=points.length;
        int time=0;
        int xP=points[0][0];
        int yP=points[0][1];
        for(int i=1;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];
            int t=Math.max(Math.abs(x-xP),Math.abs(y-yP));
            xP=x;
            yP=y;
            time+=t;
        }
        return time;
    }
}