class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(n==k){
            return "0";
        }
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            int temp=num.charAt(i)-'0';
            while(!st.isEmpty() && k>0 && temp<st.peek()){
                st.pop();
                k--;
            }
            st.push(temp);
        }
        while(k-->0){
            st.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        int idx=0;
        while(idx<sb.length() && sb.charAt(idx)=='0'){
            idx++;
        }
        return (idx==sb.length())?"0":sb.substring(idx).toString();
    }
}