class Solution {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        List<Integer> prefix=new ArrayList<>();
        for(int i=0;i<n;i++){
            int count=0;
            String temp=bank[i];
            for(int j=0;j<temp.length();j++){
                if(temp.charAt(j)=='1'){
                    count++;
                }
            }
            if(count>0){
                prefix.add(count);
            }
        }
        int total=0;
        for(int i=0;i<prefix.size()-1;i++){
            total+=prefix.get(i)*prefix.get(i+1);
        }
        return total;
    }
}