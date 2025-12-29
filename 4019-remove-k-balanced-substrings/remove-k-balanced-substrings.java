class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append('(');
        }
        for(int i=0;i<k;i++){
            sb.append(')');
        }
        int n=sb.length();
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            temp.append(ch);
            if(temp.length()>=n){
                if(temp.substring(temp.length()-n).equals(sb.toString())){
                    temp.setLength(temp.length()-n);
                }
            }
        }
        return temp.toString();
    }
}