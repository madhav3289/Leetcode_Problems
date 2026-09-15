class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {

        // find all the occurences of a in string s
        List<Integer> occOfA=KMP(s,a);

        // find all the occurences of a in string s
        List<Integer> occOfB=KMP(s,b);

        List<Integer> result=new ArrayList<>();
        // now iterate over both lists to find all the occurence 

        // using two pointers
        int i=0;
        int j=0;

        while(i<occOfA.size() && j<occOfB.size()){

            int v1=occOfA.get(i);
            int v2=occOfB.get(j);

            if(v2<v1-k){
                j++;
            }
            else if(v2>v1+k){
                i++;
            }
            else{
                result.add(v1);
                i++;
            }
        }

        return result;
    }

    // KMP implementation

    public static List<Integer> KMP(String s1,String s2){
        int n=s1.length();

        int m=s2.length();
        int [] lps=LPS(s2,m);

        List<Integer> occ=new ArrayList<>();

        int i=0;
        int j=0;

        while(i<n){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
                if(j==m){
                    occ.add(i-m);
                    j=lps[m-1];
                }
            }
            else{
                if(j==0){
                    i++;
                }
                else{
                    j=lps[j-1];
                }
            }
        }

        return occ;
    }

    public static int[] LPS(String s,int n){

        int [] lps=new int[n];

        int i=0;
        int j=1;

        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;                
            }
            else{
                if(i==0){
                    j++;
                }
                else{
                    i=lps[i-1];
                }
            }
        }

        return lps;
    }
}