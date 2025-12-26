class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int res=Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            int val=nums1[i];
            int lo=0;
            int hi=nums2.length-1;
            while(lo<=hi){
                int mid=lo+(hi-lo)/2;
                if(nums2[mid]==val){
                    res=Math.min(res,val);
                    break;
                }
                else if(nums2[mid]>val){
                    hi=mid-1;
                }
                else{
                    lo=mid+1;
                }
            }
        }
        return (res==Integer.MAX_VALUE)?-1:res;
    }
}