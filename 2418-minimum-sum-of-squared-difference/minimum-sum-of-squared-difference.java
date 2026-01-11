class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        int n = nums1.length;
        int[] diff = new int[n];
        int maxDiff = 0;

        for(int i=0;i<nums1.length;i++){
            int d= Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff,d);
            diff[i] =d;
        }

        int left =0,right =maxDiff;
        int k = k1+k2;

        long extra=0;
        while(left <= right){
            int mid = left + (right - left)/2;
            int count = 0;
            for(int i=0;i<n && count <= k;i++){
                count += Math.max(0,diff[i] - mid);
            }

            if(count <= k){
                right = mid - 1;
                extra = k - count;
            }else{
                left = mid + 1;
            }
        }

         long sum =0;
        

          for (int i = 0; i< n && left >0;i++){
            long d = Math.min(left, diff[i]);
            if (d == left && extra>0){ 
                --d;
                --extra;
            }
            sum+=d*d;
        }



        return sum;

    }
}