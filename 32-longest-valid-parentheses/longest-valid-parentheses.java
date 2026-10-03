class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int result=0;
        int op=0;
        int cd=0;

        // left to right
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') op++;
            else if(ch==')') cd++;

            if(cd>op){
                op=0;
                cd=0;
            }
            else if(op==cd){
                result=Math.max(result,op+cd);
            }
        }

        // right to left
        op=0;
        cd=0;
        for(int i=n-1;i>0;i--){
            char ch=s.charAt(i);
            if(ch=='(') op++;
            else if(ch==')') cd++;
            
            if(op>cd){
                op=0;
                cd=0;
            }
            if(op==cd){
                result=Math.max(result,op+cd);
            }
        }

        return result;
    }
}