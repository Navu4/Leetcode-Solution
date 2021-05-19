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
		ListNode slow = head;
		ListNode fast = head;

		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode head = new ListNode(0);
		ListNode curr = head;

		while(l1 != null && l2 != null){
        	if(l1.val < l2.val){
        		curr.next = l1;
        		l1 = l1.next;
        	} else {
        		curr.next = l2;
        		l2 = l2.next;	
        	}

        	curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;

		return head.next;
	}

	// Merge Sort Algorithm 
	public ListNode mergeSort(ListNode head){
        if (head == null || head.next == null)
            return head;
 
        ListNode mid = middleNode(head);
        ListNode head2 = mid.next;
        mid.next = null;
        
        ListNode newHead1 = mergeSort(head);
        ListNode newHead2 = mergeSort(head2);
        
        ListNode finalHead = mergeTwoLists(newHead1, newHead2);
 
        return finalHead;
	}
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
 
        return mergeSort(head);
    }
}