class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n=tasks.length;
        Arrays.sort(tasks);
        reverse(tasks);
        int lo=0,hi=n;
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int [] session=new int[mid];
            if(isPossible(tasks,session,sessionTime,0)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int [] tasks,int [] session,int time,int idx){
        if(idx>=tasks.length){
            return true;
        }
        Set<Integer> visited=new HashSet<>();
        for(int i=0;i<session.length;i++){
            if(visited.contains(session[i])){
                continue;
            }
            if(session[i]+tasks[idx]<=time){
                session[i]+=tasks[idx];
                if(isPossible(tasks,session,time,idx+1)){
                    return true;
                }
                session[i]-=tasks[idx];
                visited.add(session[i]);
                if(session[i]==0){
                    break;
                }
            }
        }
        return false;
    }
    public static void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}