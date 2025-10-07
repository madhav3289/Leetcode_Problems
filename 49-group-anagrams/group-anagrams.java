class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<Integer>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char [] arr=s.toCharArray();
            Arrays.sort(arr);
            String temp=new String(arr);
            if(map.containsKey(temp)){
                map.get(temp).add(i);
            }
            else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(temp,list);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String key:map.keySet()){
            List<String> res=new ArrayList<>();
            List<Integer> temp=map.get(key);
            for(int i=0;i<temp.size();i++){
                res.add(strs[temp.get(i)]);
            }
            ans.add(new ArrayList<>(res));
        }
        return ans;
    }
}