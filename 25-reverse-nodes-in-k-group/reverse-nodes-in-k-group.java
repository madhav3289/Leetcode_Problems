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
    public ListNode reverseKGroup(ListNode head, int k) {
        int currLen=0;
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;

        ListNode curr=head;
        ListNode prev=dummyNode;
        while(curr!=null){
            currLen++;
            if(currLen==k){
                ListNode endNode=curr.next;
                ListNode startNode=prev.next;
                ListNode newHead=reverseList(startNode,endNode);

                prev.next=newHead;
                startNode.next=endNode;
                prev=startNode;
                curr=endNode;
                currLen=0;
            }
            else{
                curr=curr.next;
            }
        }
        return dummyNode.next;
    }
    public static ListNode reverseList(ListNode startNode,ListNode endNode){
        ListNode curr=startNode;
        ListNode prev=null;
        ListNode front=null;
        while(curr!=endNode){
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
}