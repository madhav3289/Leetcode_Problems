class Solution {
    public class Pair{
        String word;
        int freq;
        Pair(String word,int freq){
            this.word=word;
            this.freq=freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                if(a.freq==b.freq){
                    return a.word.compareTo(b.word);
                }
                return b.freq-a.freq;
            }
        });
        for(String key:map.keySet()){
            pq.offer(new Pair(key,map.get(key)));
        }
        List<String> ans=new ArrayList<>();
        while(!pq.isEmpty() && k-->0){
            ans.add(pq.poll().word);
        }
        return ans;
    }
}