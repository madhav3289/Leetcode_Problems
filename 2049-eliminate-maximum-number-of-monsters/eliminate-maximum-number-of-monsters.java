class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
        float [] times=new float[n];
        for(int i=0;i<n;i++){
            times[i]=((float)dist[i]/speed[i]);
        }
        Arrays.sort(times);
        int count=0;
        for(int time=0;time<n;time++){
            if(times[time]>time){
                count++;
            }
            else{
                return count;
            }
        }
        return count;
    }
}