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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && n-- > 0){
            fast = fast.next;
        } 
        if(n > 0)   
            return head;
        
        ListNode prev = null;
        while(fast != null){
            prev = slow;

            fast = fast.next;
            slow = slow.next;
        }

        if(prev == null)
            return head.next;
        else{
            prev.next = slow.next;
        }

        return head;
    }
}