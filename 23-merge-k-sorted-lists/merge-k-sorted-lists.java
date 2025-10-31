/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a,ListNode b){
                return a.val-b.val;
            }
        });
        for(int i=0;i<n;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        while(!pq.isEmpty()){
            ListNode temp=pq.poll();
            head.next=new ListNode(temp.val);
            head=head.next;
            if(temp.next!=null){
                pq.add(temp.next);
            }

        }
        return dummy.next;
    }
}