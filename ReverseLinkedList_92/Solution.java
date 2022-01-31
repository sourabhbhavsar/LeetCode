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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode nodeBeforeLeft = getNthNode(dummy, left);
        ListNode nodeAtRight = getNthNode(head, right);
        ListNode nodeAfterRight = nodeAtRight.next;
        
        ListNode curr = nodeBeforeLeft.next;
        ListNode prev = nodeAtRight.next;
        while (curr != nodeAfterRight) {
            ListNode next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        nodeBeforeLeft.next = nodeAtRight;
        
        
        return dummy.next;
    }
    
    public ListNode getNthNode(ListNode curr, int n) {
        while (curr != null && n > 1) {
            curr = curr.next;
            n--;
        }
        
        return curr;
    }
}
