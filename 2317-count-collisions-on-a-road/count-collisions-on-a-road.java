class Solution {
    public int countCollisions(String s) {
        int n=s.length();
        int count=0;
        Stack<Character> st=new Stack<>();
        st.push(s.charAt(0));
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='R'){
                st.push('R');
            }
            else if(ch=='S'){
                while(!st.isEmpty() && st.peek()=='R'){
                    count++;
                    st.pop();
                }
                st.push('S');
            }
            else{
                if(st.isEmpty()){
                    st.push('L');
                }
                else if(st.peek()=='L'){
                    st.push('L');
                }
                else if(st.peek()=='S'){
                    count++;
                    st.push('S');
                }
                else{
                    count+=2;
                    st.pop();
                    while(!st.isEmpty() && st.peek()=='R'){
                        count++;
                        st.pop();
                    }
                    st.push('S');
                }
            }
        }
        return count;
    }
}