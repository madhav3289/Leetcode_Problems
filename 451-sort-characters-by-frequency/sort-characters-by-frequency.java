class Solution {
    static class Pair{
        char character;
        int freq;
        Pair(char character,int freq){
            this.character=character;
            this.freq=freq;
        }
    }
    public String frequencySort(String s) {
        int n=s.length();
        int [] freq=new int[256];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[ch-'0']++;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                if(a.freq==b.freq){
                    return a.character-b.character;
                }
                return b.freq-a.freq;
            }
        });
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                char ch=(char)(i+'0');
                pq.add(new Pair(ch,freq[i]));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            char ch=temp.character;
            for(int i=0;i<temp.freq;i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}