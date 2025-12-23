class Solution {
    public String pushDominoes(String s) {
        int n=s.length();
        int [] left=new int[n];
        Arrays.fill(left,-1);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='.'){
                if(i>0 && left[i-1]!=-1){
                    left[i]=left[i-1];
                }
            }
            else if(ch=='R'){
                left[i]=i;
            }
        }
        int [] right=new int[n];
        Arrays.fill(right,-1);
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='.'){
                if(i<n-1 && right[i+1]!=-1){
                    right[i]=right[i+1];
                }
            }
            else if(ch=='L'){
                right[i]=i;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!='.'){
                sb.append(s.charAt(i));
                continue;
            }
            if(left[i]==-1 && right[i]==-1){
                sb.append('.');
            }
            else if(left[i]!=-1 && right[i]==-1){
                sb.append('R');
            }
            else if(left[i]==-1 && right[i]!=-1){
                sb.append('L');
            }
            else{
                int dLeft=i-left[i];
                int dRight=right[i]-i;

                if(dLeft==dRight){
                    sb.append('.');
                }
                else if(dLeft>dRight){
                    sb.append('L');
                }
                else{
                    sb.append('R');
                }
            }
        }
        return sb.toString();
    }
}