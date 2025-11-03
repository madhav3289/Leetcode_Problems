class Solution {
    public int minDistance(String word1, String word2) {
        int [][] memo=new int[word1.length()+1][word2.length()+1];
        for(int [] arr:memo){
            Arrays.fill(arr,-1);
        }
        return helper(word1,word2,0,0,memo);
    }
    public static int helper(String n,String m,int i,int j,int [][] memo){
        if(i==n.length()){
            // we can only add character
            return m.length()-j;
        }
        if(j==m.length()){
            // we can only delete character
            return n.length()-i;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int add=0,del=0,rep=0;
        if(n.charAt(i)==m.charAt(j)){
            return helper(n,m,i+1,j+1,memo);
        }
        else{
            // we can add a character
            add=1+helper(n,m,i,j+1,memo);
            // we can delete a character
            del=1+helper(n,m,i+1,j,memo);
            // we can replace a character
            rep=1+helper(n,m,i+1,j+1,memo);
        }
        return memo[i][j]=Math.min(add,Math.min(del,rep));
    }
}