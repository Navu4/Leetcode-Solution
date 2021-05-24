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

    	while(fast.next != null && fast.next.next){
    		fast = fast.next.next;
    		slow = slow.next;
    	}

    	return slow;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = null;
        ListNode rightNode = null;

        ListNode curr = head;

        boolean lbool = true;
        boolean rbool = true;
        while(curr != null){
        	if(curr.val == left && lbool){
        		leftNode = curr;
        		lbool = false;
        	} else if(curr.val == right && rbool){
        		rightNode = curr;
        		rbool = false;
        	}
        	curr = curr.next;
        }

        ListNode dummy = rightNode.next;
        rightNode.next = null;

        ListNode mid = midNode(leftNode);
        ListNode newHead = reverseLinkedList(mid);
        ListNode tHead = newHead;
        while(leftNode != null && newHead != null){
        	int temp = leftNode.val;
        	leftNode.val = newHead.val;
        	newHead.val = temp;

        	leftNode = leftNode.next;
        	newHead = newHead.next;
        }

        rightNode.next = reverseLinkedList(tHead);

        return head;
    }
}