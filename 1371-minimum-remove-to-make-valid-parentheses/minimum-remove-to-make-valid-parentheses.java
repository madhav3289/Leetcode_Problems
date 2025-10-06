class Solution {
    public String minRemoveToMakeValid(String s) {
        int n=s.length();
        Set<Character> set=new HashSet<>();
        set.add('(');
        set.add(')');
        Stack<Character> st=new Stack<>();
        int op=0,cs=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!set.contains(ch)) st.push(ch);
            else{
                if(ch=='(') op++;
                else cs++;
                if(cs<=op) st.push(ch);
                else cs--;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            char ch=st.pop();
            if(op>cs && ch=='(') op--;
            else sb.append(ch);
        }
        return sb.reverse().toString();
    }
}