class Solution {
    public String decodeString(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        Stack<String> st2=new Stack<>();
        String str="";
        int num=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int x=ch-'0';
                num=num*10+x;
            }
            else if(Character.isLetter(ch)){
                str=str+ch;
            }
            else if(ch=='['){
                st.push(num);
                num=0;
                st2.push(str);
                str="";
            }
            else if(ch==']'){
                int t=st.pop();
                String temp=new String(str);
                str=st2.pop();
                for(int j=0;j<t;j++){
                    str=str+temp;
                }
            }
        }
        return str;
    }
}