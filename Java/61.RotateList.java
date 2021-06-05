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

    public int size(ListNode head){
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int n = size(head) + 1;
        
        k = (k % n  + n) % n;
        if(k == 0)
            return head;
        
        int idx = 0;
        ListNode c = head;
        while(idx < n - k){
            c = c.next;
            idx++;
        }

        ListNode nhead = c.next;
        c.next = null;

        c = nhead;
        while(c.next != null){
            c = c.next; 
        }

        c.next = head;

        return nhead;
    }
}