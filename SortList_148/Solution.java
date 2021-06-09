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
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);
        
        return merge(head1, head2);
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                curr.next = h1;
                h1 = h1.next;   
            }
            else {
                curr.next = h2;
                h2 = h2.next;
            }
            
            curr = curr.next;
        }
        
        if (h1 != null) {
            curr.next = h1;
        }
        
        if (h2 != null) {
            curr.next = h2;
        }
        
        return dummyHead.next;
    }
}
