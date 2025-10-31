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
    public ListNode swapNodes(ListNode head, int k) {
        int listLen=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            listLen++;
        }
        int st=k-1;
        int ed=listLen-st-1;
        ListNode front=head;
        while(st!=0){
            front=front.next;
            st--;
        }
        ListNode back=head;
        while(ed!=0){
            back=back.next;
            ed--;
        }
        int temp=front.val;
        front.val=back.val;
        back.val=temp;
        return head;
    }
}