class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int lo=0,hi=0;
        int max=0;
        while(hi<n){
            char ch=s.charAt(hi);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)>1){
                while(map.get(ch)>1){
                    char c=s.charAt(lo);
                    map.put(c,map.get(c)-1);
                    if(map.get(c)==0){
                        map.remove(c);
                    }
                    lo++;
                }
            }
            max=Math.max(max,hi-lo+1);
            hi++;
        }
        return max;
    }
}