class Solution {
    public int partitionString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int count=0;
        int st=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>=st){
                st=i;
                count++;
            }
            map.put(ch,i);
        }
        return count+1;
    }
}