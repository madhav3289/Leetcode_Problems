class Solution {
    static int mod=1_000_000_007;
    public int countNicePairs(int[] nums) {
        int n=nums.length;
        int [] rev=new int[n];
        for(int i=0;i<n;i++){
            rev[i]=reverseInt(nums[i]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int diff=nums[i]-rev[i];
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        int pairs=0;
        for(int key:map.keySet()){
            int t=map.get(key);
            int pair=(int)((((long)t*(t-1))/2)%mod);
            pairs=(pairs+pair)%mod;
        }
        return pairs;

    }
    public static int reverseInt(int num){
        int rev=0;
        while(num>0){
            int rem=num%10;
            rev=rev*10+rem;
            num=num/10;
        }
        return rev;
    }
}