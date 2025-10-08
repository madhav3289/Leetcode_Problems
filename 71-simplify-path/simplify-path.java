class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        int count=0,i=0;
        while(i<path.length()){
            char ch=path.charAt(i);
            while(i<path.length() && path.charAt(i)=='/'){
                i++;
            }
            StringBuilder sb=new StringBuilder();
            while(i<path.length() && path.charAt(i)!='/'){
                sb.append(path.charAt(i));
                i++;
            }
            String s=sb.toString();
            if(s.equals(".") || s.equals("")){
                continue;
            }
            else if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(s);
            }            
        }
        StringBuilder res=new StringBuilder();
        if(st.isEmpty()){
            return "/";
        }
        for(String s:st){
            res.append("/");
            res.append(s);
        }
        return res.toString();
    }
}