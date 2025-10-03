class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // we can count overlapping intervals and then can substarct from total size;
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=1;
        int last=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]-last>=0){
                count++;
                last=intervals[i][1];
            }
        }
        return n-count;
    }
}