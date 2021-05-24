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
	public ListNode reverseLinkedList(ListNode head){
		ListNode prev = null;
		ListNode curr = head;

		while(curr != null){
			ListNode forw = curr.next;

			curr.next = prev;

			prev = curr;
			curr = forw;
		}

		return prev;
	}

	public ListNode midNode(ListNode head){
		ListNode fast = head;
		ListNode slow = head;

		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = midNode(head);

        ListNode rHead = reverseLinkedList(middleNode);

       	ListNode c1 = head;
       	ListNode c2 = rHead;
       	boolean isPalindromic = true;
       	while(c1 != null && c2 != null){
       		if(c1.val != c2.val){
       			isPalindromic = false;
       			break;
       		}
       	}

       	reverseLinkedList(rHead);
       	return isPalindromic;
    }
}