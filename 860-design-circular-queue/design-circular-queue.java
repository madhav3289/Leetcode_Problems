class MyCircularQueue {

    int size;
    int maxSize;
    Node head;
    Node tail;

    public MyCircularQueue(int k) {
        size=0;
        maxSize=k;
    }
    
    public boolean enQueue(int value) {
        if(size==maxSize){
            return false;
        }
        Node node=new Node(value);
        if(size==0){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail=tail.next;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size==0){
            return false;
        }

        if(size==1){
            head=null;
            tail=null;
        }
        else{
            Node node=head.next;
            head.next=null;
            head=node;  
        }
        size--;
        return true;
    }
    
    public int Front() {
        if(size==0){
            return -1;
        }
        return head.val;
    }
    
    public int Rear() {
        if(size==0){
            return -1;
        }
        return tail.val;
    }
    
    public boolean isEmpty() {
        return (size==0)?true:false;
    }
    
    public boolean isFull() {
        return (size==maxSize)?true:false; 
    }
}

public class Node {

    int val;
    Node next;

    Node() {
    }
    Node(int val){ 
        this.val=val; 
    }
    Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */