class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int strLen=strs[0].length();
        int count=0;
        boolean [] sorted=new boolean[n-1];
        for(int i=0;i<strLen;i++){
            boolean deleted=false;
            for(int j=0;j<n-1;j++){
                if(!sorted[j] && strs[j].charAt(i)>strs[j+1].charAt(i)){
                    deleted=true;
                    count++;
                    break;
                }
            }
            if(deleted){
                continue;
            }
            for(int k=0;k<n-1;k++){
                sorted[k]=sorted[k]|(strs[k].charAt(i)<strs[k+1].charAt(i));
            }
        }
        return count;
    }
}