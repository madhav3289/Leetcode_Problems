class Solution {
    public int countVowelStrings(int n) {
        count=0;
        helper(n,0);
        return count;
    }
    static int count=0;
    public static void helper(int n,int idx){
        if(n==0){
            count++;
            return;
        }
        for(int i=0;i<5;i++){
            if(i>=idx){
                helper(n-1,i);
            }
        }
    }
}