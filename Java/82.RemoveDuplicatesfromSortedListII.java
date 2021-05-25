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

	// Optimized Solution
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummyHead = new ListNode(-1000, head);
        ListNode prev = dummyHead;
        ListNode curr = head;
        
        while(curr != null){
            ListNode forw = curr.next;
            
            if(forw != null && curr.val == forw.val){
                int ele = curr.val;
                while(curr != null && curr.val == ele){
                    curr = curr.next;
                }
                prev.next = curr;
                continue;
            }
            
            
            prev = curr;
            curr = forw;
        }
        
        return dummyHead.next;
    }
}