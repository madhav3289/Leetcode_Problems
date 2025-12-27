class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m=meetings.length;
        // sorting logic >> sort the meetings based on starting index
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        // create a priority to know which priority queue are currenty empty or occupied
        PriorityQueue<int[]> pq1=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int [] a,int [] b){
                if(a[1]==b[1]){
                    return a[0]-b[0];
                }
                return a[1]-b[1];
            }
        });
        // create another priority to use the most optimal empty room
        PriorityQueue<int[]> pq2=new PriorityQueue<>((a,b)->a[0]-b[0]);
        // at first all the rooms are empty so add them all to pq1
        for(int i=0;i<n;i++){
            pq1.add(new int[]{i,0});
        }
        // frequency to store which room is used how many times
        int [] freq=new int[n];
        // iterate over meetings
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
            
            // check when is the actual starting time
            int nSt=Math.max(use[1],st);
            pq1.add(new int[]{use[0],nSt+(ed-st)});     // now this room is occupied until the meetings ended so add it to pq1
            // >> (ed-st) suggests the duration of this meeting.
        }
        // find the index which has maximum frequency ans return it
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