class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        long [] freq=new long[32];
        for(int key:set){
            int bits=countSetBits(key);
            freq[bits]++;
        }
        long count=0;
        for(int i=0;i<32;i++){
            if(freq[i]==0){
                continue;
            }
            for(int j=0;j<32;j++){
                if(freq[j]==0){
                    continue;
                }
                if(i+j>=k){
                    count+=freq[i]*freq[j];
                }
            }
        }
        return count;        
    }
    public static int countSetBits(int num){
        int count=0;
        while(num>0){
            if((num&1)==1){
                count++;
            }
            num=num>>1;
        }
        return count;
    }
}