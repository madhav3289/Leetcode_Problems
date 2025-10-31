/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node dummy=new Node(-1);
        Node head1=dummy;
        Node temp=head;
        while(temp!=null){
            Node nn=new Node(temp.val);
            map.put(temp,nn);
            head1.next=nn;
            temp=temp.next;
            head1=head1.next;
        }
        temp=head;
        Node tail=dummy.next;
        while(tail!=null){
            if(temp.random!=null){
                tail.random=map.get(temp.random);
            }
            temp=temp.next;
            tail=tail.next;
        }
        return dummy.next;
    }
}