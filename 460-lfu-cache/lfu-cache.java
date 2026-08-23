class LFUCache {

    HashMap<Integer,Node> map;
    TreeMap<Integer,List<Node>> freq;
    int maxSize;
    int curSize;

    public LFUCache(int capacity) {
        freq=new TreeMap<>();
        map=new HashMap<>();
        maxSize=capacity;
        curSize=0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node temp=map.get(key);
        int val=temp.value;

        // update existing
        addNode(key,val);

        removeNode(temp);
        return val;        
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){

            //check the size
            if(curSize==maxSize){
                int c=freq.firstKey();
                // first node element in least recently used
                Node n=freq.get(c).get(0).next;

                map.remove(n.key);

                removeNode(n);
            }
            else{
                curSize++;
            }
            // add new node
            addNode(key,value);
        }
        else{
            // update
            Node n=map.get(key);

            addNode(key,value);
            removeNode(n);
        }
    }

    public void removeNode(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    
        // if no key value pair exists for same count except head and tail, remove the key from frequency
        List<Node> list=freq.get(n.count);
        Node head=list.get(0);
        Node tail=list.get(1);

        if(head.next==tail){
            freq.remove(n.count);
        }
        n.next=null;
        n.prev=null;        
    }

    public void addNode(int key,int value){
        int ct=0;
        if(map.containsKey(key)){
            ct=map.get(key).count;
        }
        ct++;

        Node temp=new Node(key,value,ct);

        if(!freq.containsKey(ct)){
            Node head=new Node(-1,-1,-1);
            Node tail=new Node(-1,-1,-1);

            head.next=tail;
            tail.prev=head;

            freq.put(ct,new ArrayList<>(List.of(head,tail)));
        }

        Node tail=freq.get(ct).get(1);

        tail.prev.next=temp;
        temp.prev=tail.prev;

        temp.next=tail;
        tail.prev=temp;

        map.put(key,temp);
    }
}

class Node{
    int key;
    int value;
    int count;
    Node prev;
    Node next;

    Node(int key,int value,int count){
        this.key=key;
        this.value=value;
        this.count=count;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */