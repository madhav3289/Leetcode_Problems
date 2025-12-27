class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int ans=1;
        // case 1 >> "abcbcaabc"  (contains all three characters)
        // check for "a & b" >> +1 for a and -1 for b 
        // check for "b & c" >> +1 for c and -1 for b
        int val1=0,val2=0;
        HashMap<Long,Integer> map=new HashMap<>();
        long st=(((long)0)<<32)|(0&0xffffffffL);
        map.put(st,-1);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                val1++;
            }else if(ch=='c'){
                val2++;
            }else if(ch=='b'){
                val1--;
                val2--;
            }else{
                val1=0;
                val2=0;
                map=new HashMap<>();
                map.put(0L,i);
                continue;
            }
            long key=(((long)val1)<<32)|(val2&0xffffffffL);
            if(!map.containsKey(key)){
                map.put(key,i);
            }
            ans=Math.max(ans,i-map.get(key));
        }
        // case 2 >> "aaaaa" only single type of character
        int count=1;
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(ch==s.charAt(i-1)){
                count++;
            }
            else{
                count=1;
            }
            ans=Math.max(ans,count);
        }
        // case 3 >> "abcbcbcbcbc" for characters contains only two types of elements 
        String [] arr={"ab","bc","ac"};
        for(String str:arr){
            int val=0;
            char x=str.charAt(0);
            char y=str.charAt(1);
            HashMap<Integer,Integer> mp=new HashMap<>();
            mp.put(0,-1);
            for(int i=0;i<n;i++){
                char ch=s.charAt(i);
                if(ch==x){
                    val++;
                }else if(ch==y){
                    val--;
                }else{
                    val=0;
                    mp=new HashMap<>();
                    mp.put(0,i);
                    continue;
                }
                if(!mp.containsKey(val)){
                    mp.put(val,i);
                }
                ans=Math.max(ans,i-mp.get(val));
            }
        }
        return ans;
    }
}