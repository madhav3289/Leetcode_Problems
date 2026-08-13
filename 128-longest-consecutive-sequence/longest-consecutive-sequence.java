class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i],false);
            }
            else{
                map.put(nums[i],true);
            }
            if(map.containsKey(nums[i]+1)){
                map.put(nums[i]+1,false);
            }
        }

        int maxi=0;
        for(int key:map.keySet()){
            if(map.get(key)==true){
                int count=0;
                int temp=key;
                while(map.containsKey(temp)){
                    count++;
                    temp++;
                }
                maxi=Math.max(maxi,count);
            }
        }
        return maxi;
    }
}