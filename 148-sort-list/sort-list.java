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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode middle=middleOfList(head);
        ListNode leftList=head;
        ListNode rightList=middle.next;
        middle.next=null;

        leftList=sortList(leftList);
        rightList=sortList(rightList);

        return mergeTwoLists(leftList,rightList);
    }
    public static ListNode mergeTwoLists(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                temp.next=new ListNode(head1.val);
                head1=head1.next;
            }
            else{
                temp.next=new ListNode(head2.val);
                head2=head2.next;
            }
            temp=temp.next;
        }
        while(head1!=null){
            temp.next=new ListNode(head1.val);
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=new ListNode(head2.val);
            head2=head2.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    public static ListNode middleOfList(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}