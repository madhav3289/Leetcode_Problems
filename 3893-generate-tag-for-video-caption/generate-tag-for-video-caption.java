class Solution {
    public String generateTag(String caption) {
        int n=caption.length();
        StringBuilder sb=new StringBuilder();
        sb.append('#');
        for(int i=0;i<n;i++){
            char ch=caption.charAt(i);
            if(ch==' '){
                continue;
            }
            if(i>0 && caption.charAt(i-1)==' '){
                if(Character.isLowerCase(ch)){
                   sb.append(Character.toUpperCase(ch));
                   continue;
                }
            }
            else{
                if(Character.isUpperCase(ch)){
                   sb.append(Character.toLowerCase(ch));
                   continue;
                }
            }
            sb.append(ch);
        }
        if(sb.length()>1){
            sb.setCharAt(1,Character.toLowerCase(sb.charAt(1)));
        }
        String res=sb.toString();
        return (res.length()<=100)?res:res.substring(0,100);
    }
}