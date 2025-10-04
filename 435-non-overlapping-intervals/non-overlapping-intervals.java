class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // we can count overlapping intervals and then can substarct from total size;
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int count=1;
        int last=intervals[0][1];
        for(int i=1;i<n;i++){
            if(last-intervals[i][0]<=0){
                count++;
                last=intervals[i][1];
            }
            else{
                last=Math.min(last,intervals[i][1]);
            }
        }
        return n-count;
    }
}