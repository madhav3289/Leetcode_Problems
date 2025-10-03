class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int count=1;
        int last=points[0][1];
        for(int i=1;i<n;i++){
            if(points[i][0]>last){
                count++;
                last=points[i][1];
            }
            else{
                last=Math.min(last,points[i][1]);
            }
        }
        return count;
    }
}