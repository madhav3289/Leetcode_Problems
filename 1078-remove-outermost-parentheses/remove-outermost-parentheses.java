class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
                if(st.size()>1){
                    res.append(ch);
                }
            }
            else{
                st.pop();
                if(st.size()>0){
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }
}