class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        int count=0;
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }
            else{
                if(i+1>=n || s.charAt(i+1)!=')'){
                    if(st.isEmpty()){
                        count+=2;
                    }
                    else{
                        count+=1;
                        st.pop();
                    }
                }

                else if(s.charAt(i+1)==')'){
                    if(st.isEmpty()){
                        count++;
                    }
                    else{
                        st.pop();
                    }
                    i++;
                }
            }
            i++;
        }
        count+=st.size()*2;
        return count;
    }
}