class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Set<String> set=new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("/");
        set.add("*");
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            String s=tokens[i];
            if(set.contains(s)){
                int num1=st.pop();
                int num2=st.pop();
                int res=0;
                if(s.equals("+")){
                    res=num1+num2;
                }
                else if(s.equals("-")){
                    res=num2-num1;
                }
                else if(s.equals("*")){
                    res=num1*num2;
                }
                else{
                    res=num2/num1;
                }
                st.push(res);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}