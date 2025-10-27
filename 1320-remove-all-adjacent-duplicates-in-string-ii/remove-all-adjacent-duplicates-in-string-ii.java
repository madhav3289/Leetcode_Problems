class Solution {
    public class Pair{
        char ele;
        int freq;
        Pair(char ele,int freq){
            this.ele=ele;
            this.freq=freq;
        }
    }
    public String removeDuplicates(String s, int k) {
        int n=s.length();
        Stack<Pair> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty()){
                if(st.peek().ele==ch){
                    st.push(new Pair(ch,st.peek().freq+1));
                }
                else{
                    st.push(new Pair(ch,1));
                }
                if(st.peek().freq==k){
                    for(int j=0;j<k;j++){
                        st.pop();
                    }
                }
            }
            else{
                st.push(new Pair(ch,1));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek().ele);
            st.pop();
        }
        return sb.reverse().toString();
    }
}