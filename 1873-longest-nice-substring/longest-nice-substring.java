class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length()<2){
            return "";
        }
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(Character.toLowerCase(ch)) && set.contains(Character.toUpperCase(ch))){
                continue;
            }
            String prev=longestNiceSubstring(s.substring(0,i));
            String next=longestNiceSubstring(s.substring(i+1,s.length()));
            
            if(prev.length()>=next.length()) return prev;
            else return next;
        }
        return s;
    }
}