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
    public ListNode reverseLinkedList(ListNode head, ListNode after){
    	ListNode prev = after;
    	ListNode curr = head;

    	while(curr != null){
    		ListNode forw = curr.next;

    		curr.next = prev;

    		prev = curr;
    		curr = forw;
    	}

    	return prev;
    }
    

    // My Solution 
    public ListNode reverseBetween(ListNode head, int left, int right) {
    	if(head == null || head.next == null || left == right)
    		return head;
        ListNode dummyHead = new ListNode(0, head);
        ListNode c = dummyHead;

        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode prev = null;
        ListNode after = null;

        int idx = 0;
        while(c != null){
        	if(idx + 1 == left){
        		prev = c;
        		leftNode = c.next;
                System.out.println(c.val);
        	}else if(idx == right){
        		rightNode = c;
        	}
        	idx++;
        	c = c.next;
        }

        if(rightNode != null){
        	after = rightNode.next;
        	rightNode.next = null;
        }
        

        ListNode newHead = reverseLinkedList(leftNode, after);
        prev.next = newHead;
       
        return dummyHead.next;
    }


    // Discussion
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;   
        
        ListNode h = null;  // temp head
        ListNode t = null;  // tail, temp
        // make life easier use dummy node
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;

        while (p != null && (h == null || t == null) )
        {
            // node before left 
            if (left == 1)
                h = p;

            // right node
            if (right == 0)
                t = p;  

            left--;
            right--;
            p = p.next;
        }

        // pop sublist and splice ends
        p = h.next;         // start of sublist
        h.next = t.next;    // splice ends
        t.next = null;      // terminate sublist

        // push sublist items back
        while (p != null)
        {
            t = p.next;     // temp
            p.next = h.next;
            h.next = p;
            p = t;          // next node                
        }                   
               
        return head.next;
    }
}