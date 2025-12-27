class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m=meetings.length;
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq1=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int [] a,int [] b){
                if(a[1]==b[1]){
                    return a[0]-b[0];
                }
                return a[1]-b[1];
            }
        });
        PriorityQueue<int[]> pq2=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            pq1.add(new int[]{i,0});
        }
        int [] freq=new int[n];
        for(int i=0;i<m;i++){
            int st=meetings[i][0];
            int ed=meetings[i][1];
            // choose all the rooms that are free
            while(!pq1.isEmpty() && pq1.peek()[1]<=st){
                int [] p=pq1.poll();
                pq2.add(p);
            }
            // select the room
            int [] use=(pq2.isEmpty())?pq1.poll():pq2.poll();
            // increment the room count
            freq[use[0]]++;
            // now this room is occupied untilthe meetings ended so add it to pq2
            int nSt=Math.max(use[1],st);
            pq1.add(new int[]{use[0],nSt+(ed-st)});
        }
        int max=0;
        int idx=0;
        for(int i=0;i<n;i++){
            if(freq[i]>max){
                max=freq[i];
                idx=i;
            }
        }
        return idx;
    }
}