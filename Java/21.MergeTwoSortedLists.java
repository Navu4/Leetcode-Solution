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

    // Using Space by Creating List 
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while(l1 != null && l2 != null){
        	if(l1.val < l2.val){
        		head.next = new ListNode(l1.val);
        		l1 = l1.next;
        	} else {
        		head.next = new ListNode(l2.val);
        		l2 = l2.next;	
        	}

        	head = head.next;
        }

        while(l1 != null){
        	head.next = new ListNode(l1.val);
        	l1 = l1.next;

        	head = head.next;
        }

        while(l2 != null){
        	head.next = new ListNode(l2.val);
        	l2 = l2.next;

        	head = head.next;
        }

        return curr.next;
    }

    // Without using Space 
    // Time complexity is Same
        
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            if(l1 != null)  return l1;
            if(l2 != null)  return l2;
            
            return l1;
        }
        
        ListNode ans = new ListNode();
        ListNode head = ans;
        
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        if(c1.val < c2.val){
            ans.val = c1.val;
            c1 = c1.next;
        }   else {
            ans.val = c2.val;
            c2 = c2.next;
        }
        
        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                
                ListNode node = new ListNode(c1.val);
                ans.next = node;
                ans = node;
                
                c1 = c1.next;
            } else {
                
                ListNode node = new ListNode(c2.val);
                ans.next = node;
                ans = node;
                
                c2 = c2.next;
            }
        }
        
        while(c1 != null){
            ListNode node = new ListNode(c1.val);
            ans.next = node;
            ans = node;

            c1 = c1.next;
        }
        
        while(c2 != null){
            
            ListNode node = new ListNode(c2.val);
            ans.next = node;
            ans = node;

            c2 = c2.next;
        }
        
        return head;
    }
}