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
    public ListNode mergeTwoSortedLL(ListNode l1, ListNode l2){
    	if(l1 == null || l2 == null)	
    		return l1 == null ? l2 : l1;

    	ListNode newHead = new ListNode(-1);
    	ListNode prev = newHead;
    	ListNode c1 = l1, c2 = l2;

    	while(c1 != null && c2 != null){
    		if(c1.val < c2.val){
    			prev.next = c1;
    			c1 = c1.next;
    		} else {
    			prev.next = c2;
    			c2 = c2.next;
    		}

    		prev = prev.next;
    	}

    	prev.next = c1 == null ? c2 :  c1;
    	return newHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists, int st, int ei){
    	if(st > ei)	return null;
    	if(st == ei)	return lists[st];

        int mid = (st + ei) / 2;
        
        ListNode l1 = mergeKLists(lists, st, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, ei);

        return mergeTwoSortedLL(l1, l2);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 )	return null;

        return mergeKLists(lists, 0, lists.length - 1);
    }
}