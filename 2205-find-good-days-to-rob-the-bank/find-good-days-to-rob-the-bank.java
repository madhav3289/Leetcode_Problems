class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n=nums.length;
        int [] prefix=new int[n];
        prefix[0]=0;
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1]){
                prefix[i]=prefix[i-1]+1;
            }
            else{
                prefix[i]=0;
            }
        }
        int [] suffix=new int[n];
        suffix[0]=0;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<=nums[i+1]){
                suffix[i]=suffix[i+1]+1;
            }
            else{
                suffix[i]=0;
            }
        }
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(prefix[i]>=time && suffix[i]>=time){
                result.add(i);
            }
        }
        return result;
    }
}