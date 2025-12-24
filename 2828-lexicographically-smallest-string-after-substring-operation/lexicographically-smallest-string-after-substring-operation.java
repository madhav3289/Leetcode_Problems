class Solution {
    public String smallestString(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<n && s.charAt(i)=='a'){
            i++;
        }
        if(i==n){
            sb.append(s);
            sb.setCharAt(n-1,'z');
            return sb.toString();
        }
        sb.append(s.substring(0,i));
        while(i<n && s.charAt(i)!='a'){
            char ch=s.charAt(i);
            char temp=(char)(((ch-'a')-1)+'a');
            sb.append(temp);
            i++;
        }
        sb.append(s.substring(i));
        return sb.toString();
    }
}