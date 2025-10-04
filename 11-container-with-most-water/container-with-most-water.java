class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int lo=0;
        int hi=n-1;
        int ans=0;
        while(lo<=hi){
            int area=(hi-lo)*Math.min(height[lo],height[hi]);
            ans=Math.max(area,ans);
            if(height[lo]<=height[hi]){
                lo++;
            }
            else{
                hi--;
            }
        }
        return ans;
    }
}