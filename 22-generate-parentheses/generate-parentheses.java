class Solution {
    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        solve(n,0,0,new StringBuilder());
        return result;
    }
    List<String> result;

    public void solve(int n,int op,int cd,StringBuilder sb){
        if(op==n && cd==n){
            result.add(sb.toString());
            return;
        }
        if(op>n || cd>op){
            return;
        }
        char [] ch={'(',')'};
        for(int i=0;i<2;i++){
            sb.append(ch[i]);
            if(i==0) solve(n,op+1,cd,sb);
            else if(i==1) solve(n,op,cd+1,sb);

            sb.deleteCharAt(sb.length()-1);
        }
    }
}