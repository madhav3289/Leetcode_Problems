class Solution {
    public int minimumBuckets(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        int count=0;
        for(int i=0;i<n;i++){
            char ch=sb.charAt(i);
            if(ch=='H'){
                if(i>0 && sb.charAt(i-1)=='#'){
                    continue;
                }
                if(i<n-1 && sb.charAt(i+1)=='.'){
                    sb.setCharAt(i+1,'#');
                    count++;
                }
                else if(i>0 && sb.charAt(i-1)=='.'){
                    sb.setCharAt(i-1,'#');
                    count++;
                }
                else{
                    return -1;
                }
            }
        }
        return count;
    }
    // public int minimumBuckets(String s) {
    //     int n=s.length();
    //     // to handle case like "H" or "."
    //     if(n==1){
    //         return (s.charAt(0)=='H')?-1:0;
    //     }
    //     // to handle edge cases like "HH..." or "...HH"
    //     if((s.charAt(0)=='H' && s.charAt(1)=='H') || (s.charAt(n-2)=='H' && s.charAt(n-1)=='H')){
    //         return -1;
    //     }
    //     // to handle cases like "..HHH.."
    //     int count=0,total=0;
    //     for(int i=0;i<n;i++){
    //         if(s.charAt(i)=='H'){
    //             count++;
    //             // if we get more than two hamsters contineously, we can't give food to 
    //             // middle one so, it is impossible to fed all hamsters so directly return -1..
    //             if(count>2){
    //                 return -1;
    //             }
    //         }
    //         else count=0;
    //     }
    // }
}