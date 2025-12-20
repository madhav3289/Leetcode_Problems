class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        if(n==1){
            return false;
        }
        int len=1;
        String str="";
        for(int i=0;i<s.length();i++){
            str+=s.charAt(i);
            if(n%len==0){
                String temp="";
                int count=n/len;
                for(int j=0;j<count;j++){
                    temp+=str;
                }
                if(temp.equals(s)){
                    return true;
                }
            }
            len++;
            if(len>n/2){
                return false;
            }
        }
        return false;
    }
}