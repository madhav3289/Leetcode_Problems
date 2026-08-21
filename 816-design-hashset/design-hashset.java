class MyHashSet {

    List<List<Integer>> list;
    int bucket;

    public MyHashSet() {
        list=new ArrayList<>();
        bucket=15000;
        for(int i=0;i<bucket;i++){
            list.add(new ArrayList<>());
        }
    }

    public int getKey(int key){
        return key%bucket;
    }
    
    public void add(int key) {
        int mod=getKey(key);

        for(int i=0;i<list.get(mod).size();i++){
            if(list.get(mod).get(i)==key){
                return;
            }
        }
        list.get(mod).add(key);
        
    }
    
    public void remove(int key) {
        int mod=getKey(key);

        for(int i=0;i<list.get(mod).size();i++){
            if(list.get(mod).get(i)==key){
                list.get(mod).remove(i);
            }
        }
    }
    
    public boolean contains(int key) {
        int mod=getKey(key);

        for(int i=0;i<list.get(mod).size();i++){
            if(list.get(mod).get(i)==key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */