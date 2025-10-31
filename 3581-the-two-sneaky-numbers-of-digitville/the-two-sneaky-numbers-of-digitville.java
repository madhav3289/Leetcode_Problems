class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int [] freq=new int[101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<freq.length;i++){
            if(freq[i]==2){
                ans.add(i);
            }
        }
        int [] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}