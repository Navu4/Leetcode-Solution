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
    public int length(ListNode head){
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        return size;
    }
    
    public ListNode[] splitListToParts(ListNode root, int k) {
        if(root == null){
          return new ListNode[k];  
        } 
        ListNode curr = root;
        int idx = 0;
        int size = length(root); // Size of LL
        
        ListNode[] ans = new ListNode[k];
        int groups = size/k;  // No. of Element should b present in a Group
        int extraele = size % k; // Extra Element 
        
        ListNode ptr = root;
    
        // Handling Single element in group case 
        if(size <= k){
            for(int i = 0; i < size; i++){
                ListNode frw = ptr.next;
                ans[i] = ptr;
                ptr.next = null;
                ptr = frw;
            }
            return ans;
        }
        
        
        // For multiple Element in a Group 
        int val = k;
        while(val-- > 0){
            int tempg = groups;
            ListNode th = new ListNode(-1);  // dummy node for null value safety
            ListNode tt = th;
            if(extraele > 0){  // Change Extra element value 
                tempg += 1;
                extraele--;
            }
            while(tempg-- > 0){  // Fill LL with group elements
                ListNode frw = curr.next;
                
                curr.next = null;
                
                tt.next = curr;
                tt = tt.next;
                curr = frw;
            }
            ans[idx++] = th.next;  // Storing the head at idx value
        }
        return ans;
    }
}