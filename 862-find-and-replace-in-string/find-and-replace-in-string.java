class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n=indices.length;
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Pair(indices[i],sources[i],targets[i]));
        }
        Collections.sort(list,(a,b)->a.idx-b.idx);
        StringBuilder sb=new StringBuilder();
        int prevIdx=0;
        for(int i=0;i<n;i++){

            Pair temp=list.get(i);
            int index=temp.idx;
            String og=temp.ogStr;
            String rp=temp.rpStr;

            if(index<prevIdx){
                continue;
            }
            sb.append(s.substring(prevIdx,index));

            if(index+og.length()<=s.length() && s.substring(index,index+og.length()).equals(og)){
                sb.append(rp);
                prevIdx=index+og.length();
            }
            else{
                // sb.append(s.charAt(index));
                prevIdx=index;
            } 
        }
        sb.append(s.substring(prevIdx));
        return sb.toString();
    }
    static class Pair{
        int idx;
        String ogStr;
        String rpStr;
        Pair(int idx,String ogStr,String rpStr){
            this.idx=idx;
            this.ogStr=ogStr;
            this.rpStr=rpStr;
        }
    }
}