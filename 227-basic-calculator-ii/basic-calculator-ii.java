class Solution {
    public int calculate(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        char op='+';
        int num=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int x=ch-'0';
                num=num*10+x;
            }
            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(op=='+'){
                    st.push(num);
                }
                else if(op=='-'){
                    st.push(-1*num);
                }
                else if(op=='*'){
                    st.push(st.pop()*num);
                }
                else if(op=='/'){
                    st.push(st.pop()/num);
                }
                if(!Character.isDigit(ch)){
                    op=ch;
                }
                num=0;
            }
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
        
    }
}