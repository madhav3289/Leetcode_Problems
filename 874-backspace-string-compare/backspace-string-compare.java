class Solution {
    public boolean backspaceCompare(String s, String t) {
        int n1=s.length();
        Stack<Character> st1=new Stack<>();
        for(int i=0;i<n1;i++){
            char ch=s.charAt(i);
            if(ch=='#'){
                if(!st1.isEmpty()) st1.pop();
            }
            else st1.push(ch);
        }
        StringBuilder sb1=new StringBuilder();
        while(!st1.isEmpty()) sb1.append(st1.pop());

        int n2=t.length();
        Stack<Character> st2=new Stack<>();
        for(int i=0;i<n2;i++){
            char ch=t.charAt(i);
            if(ch=='#'){
                if(!st2.isEmpty()) st2.pop();
            }
            else st2.push(ch);
        }
        StringBuilder sb2=new StringBuilder();
        while(!st2.isEmpty()) sb2.append(st2.pop());

        return sb1.toString().equals(sb2.toString());
    }
}