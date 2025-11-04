class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int lo=0,hi=0;
        int [] freq=new int[51];
        int [] ans=new int[n-k+1];
        int idx=0;
        while(hi<n){
            PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
                @Override
                public int compare(int [] a,int [] b){
                    if(a[1]==b[1]){
                        return b[0]-a[0];
                    }
                    return b[1]-a[1];
                }
            });
            if(hi-lo+1>k){
                freq[nums[lo]]--;
                lo++;
            }
            if(hi-lo+1<=k){
                freq[nums[hi]]++;
            }
            if(hi-lo+1==k){
                for(int i=0;i<freq.length;i++){
                    if(freq[i]!=0){
                        pq.add(new int[]{i,freq[i]});
                    }
                }
                int num=0;
                int val=x;
                while(!pq.isEmpty() && val-->0){
                    int [] a=pq.poll();
                    num=num+(a[0]*a[1]);
                }
                ans[idx++]=num;
            }
            hi++;
        }
        return ans;
    }
}