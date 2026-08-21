class MyHashMap {

    List<List<int[]>> list;
    int bucket;

    public MyHashMap() {
        list=new ArrayList<>();
        bucket=15000;
        for(int i=0;i<bucket;i++){
            list.add(new ArrayList<>());
        }

    }

    public int getKey(int key){
        return key%bucket;
    }
    
    public void put(int key, int value) {
        int mod=getKey(key);
        int flag=-1;

        for(int i=0;i<list.get(mod).size();i++){
            int [] temp=list.get(mod).get(i);
            if(temp[0]==key){
                list.get(mod).remove(i);
                list.get(mod).add(new int[]{key,value});
                flag=1;
            }
        }
        if(flag==-1){
            list.get(mod).add(new int[]{key,value});
        }
    }
    
    public int get(int key) {
        int mod=getKey(key);

        for(int i=0;i<list.get(mod).size();i++){
            int [] temp=list.get(mod).get(i);
            if(temp[0]==key){
                return temp[1];
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int mod=getKey(key);

        for(int i=0;i<list.get(mod).size();i++){
            int [] temp=list.get(mod).get(i);
            if(temp[0]==key){
                list.get(mod).remove(i);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */