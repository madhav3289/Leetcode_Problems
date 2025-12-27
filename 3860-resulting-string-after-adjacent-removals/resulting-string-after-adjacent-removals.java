class Solution {
    public String resultingString(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
            }
            else{
                if((st.peek()=='z' && ch=='a') ||(st.peek()=='a' && ch=='z')){
                    st.pop();
                    continue;
                }
                if(Math.abs((ch-'a')-(st.peek()-'a'))==1){
                    st.pop();
                    continue;
                }
                else{
                    st.push(ch);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}