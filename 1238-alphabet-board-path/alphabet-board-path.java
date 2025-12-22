class Solution {
    public String alphabetBoardPath(String target) {
        int n=target.length();
        int row=0,col=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=target.charAt(i);
            int cRow=(ch-'a')/5;
            int cCol=(ch-'a')%5;
            while(row>cRow){
                sb.append('U');
                row--;
            }
            while(col<cCol){
                sb.append('R');
                col++;
            }
            while(col>cCol){
                sb.append('L');
                col--;
            }
            while(row<cRow){
                sb.append('D');
                row++;
            }
            sb.append('!');
        }
        return sb.toString();
    }
}