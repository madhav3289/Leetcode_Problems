class Solution {
    public int countCollisions(String dir) {
        int n=dir.length();
        Stack<Character> st=new Stack<>();
        int count=0;
        st.push(dir.charAt(0));
        for(int i=1;i<n;i++){
            char ch=dir.charAt(i);
            if(ch=='L'){
                if(st.isEmpty()){
                    st.push('L');
                }
                else if(st.peek()=='S'){
                    count+=1;
                    st.push('S');
                }
                else if(st.peek()=='R'){
                    count+=2;
                    st.pop();
                    while(!st.isEmpty() && st.peek()=='R'){
                        count+=1;
                        st.pop();
                    }
                    st.push('S');
                }
                else{
                    st.push('L');
                }
            }
            else if(ch=='S'){
                while(!st.isEmpty() && st.peek()=='R'){
                    count+=1;
                    st.pop();
                }
                st.push('S');
            }
            else{
                st.push('R');
            }
        }
        return count;
    }
}