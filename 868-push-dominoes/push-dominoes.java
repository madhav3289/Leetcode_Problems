class Solution {
    public String pushDominoes(String s) {
        int n=s.length();

        int [] right=new int[n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='L'){
                continue;
            }
            else if(s.charAt(i)=='R'){
                right[i]=1;
            }
            else if(i>0 && right[i-1]!=0){
                right[i]=right[i-1]+1;
            }
        }

        int [] left=new int[n];
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='R'){
                continue;
            }
            else if(s.charAt(i)=='L'){
                left[i]=1;
            }
            else if(i<n-1 && left[i+1]!=0){
                left[i]=left[i+1]+1;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(left[i]==0 && right[i]!=0){
                sb.append('R');
            }
            else if(right[i]==0 && left[i]!=0){
                sb.append('L');
            }
            else if(right[i]==left[i]){
                sb.append('.');
            }
            else{
                if(right[i]>left[i]){
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