class Solution {
    public int maxRepeating(String sequence, String word) {
        String newWord=word;
        int st=0;
        int count=0;
        while(true){
            int idx=sequence.substring(st).indexOf(newWord);
            if(idx==-1){
                return count;
            }
            else{
                count++;
                st=idx;
                newWord=newWord.concat(word);
            }
        }
    }
}