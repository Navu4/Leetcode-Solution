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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode c1 = list1, c2 = list2;
        int n = 1;
        while(n++ < a){
            c1 = c1.next;
        }
        ListNode temp = c1.next;
        c1.next = list2;

        while(n++ <= b){
            temp = temp.next;
        }

        while(list2.next != null){
            list2 = list2.next; 
        }

        list2.next = temp.next;
        temp.next = null;
        
        return list1;  
    }
}