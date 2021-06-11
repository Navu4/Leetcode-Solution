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
    public ListNode middleNode(ListNode head){
    	ListNode slow = head, fast = head;
    	while(fast.next != null && fast.next.next != null){
    		slow = slow.next;
    		fast = fast.next.next;
    	}

    	return slow;
    }
    
    public ListNode reverse(ListNode head){
    	ListNode prev = null, curr = head;
    	while(curr != null){
    		ListNode forw = curr.next;

    		curr.next = prev;

    		prev = curr;
    		curr = forw;
    	}

    	return prev;
    }

    public ListNode merge(ListNode l1, ListNode l2){
    	ListNode dummy = new ListNode(-1);
    	ListNode prev = dummy, c1 = l1, c2 = l2;

    	while(c1 != null && c2 != null){
    		prev.next = c1; // First List
    		c1 = c1.next;

    		prev = prev.next; // Move

    		prev.next = c2;
    		c2 = c2.next;

    		prev = prev.next;
    	}

    	prev.next = c1 != null ? c1 : c2;

    	return dummy.next;
    }
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
        	return head;

        ListNode mid = middleNode(head);
        ListNode nHead = mid.next;
        mid.next = null;

        ListNode rHead = reverse(nHead);

        return merge(head, rHead);

    }
}