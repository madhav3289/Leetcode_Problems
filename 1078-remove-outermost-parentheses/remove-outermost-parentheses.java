class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==')'){
                count--;
                if(count!=0){
                    sb.append(ch);
                }
            }
            else{
                count++;
                if(count>1){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}