class Solution {

    // Brute Force -> O(n*n)

    // public int numberOfSubstrings(String s) {
    //     int n=s.length();
    //     int count=0;
    //     for(int i=0;i<n;i++){
    //         int zero=0;
    //         int ones=0;
    //         for(int j=i;j<n;j++){
    //             if(s.charAt(j)=='0'){
    //                 zero++;
    //             }
    //             else{
    //                 ones++;
    //             }
    //             if((long)Math.pow(zero,2)<=(long)ones){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // Optimal(Using Sliding Window) -> O(n*sqrt(n))
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int [] prefix=new int[n];
        if(s.charAt(0)=='1'){
            prefix[0]=1;
        }
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='1'){
                prefix[i]=prefix[i-1]+1;
            }
            else{
                prefix[i]=prefix[i-1];
            }
        }
        // 0001111011
        // prefix={0,0,0,1,2,3,4,4,5,6};
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int ones=prefix[j]-((i==0)?0:prefix[i-1]);
                int zero=(j-i+1)-ones;
                if((zero*zero)>ones){
                    int need=(zero*zero)-ones;
                    j+=need-1;
                }
                else if((zero*zero)==ones){
                    count++;
                }
                else{
                    count++;
                    int k=(int)Math.sqrt(ones)-zero;
                    int need=j+k;
                    if(need>=n){
                        count+=(n-j-1);
                        break;
                    }
                    else{
                        count+=k;
                    }
                    j=need;
                }
            }
        }
        return count;
    }
}