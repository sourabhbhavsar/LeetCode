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
    public void reorderList(ListNode head) {
        
        if (head == null) {
            return;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow;
        ListNode oneAfterMid = mid.next;
        mid.next = null;
        
        ListNode p2 = reverse(oneAfterMid);
        ListNode p1 = head;
        
        while (p1 != null && p2 != null) {
            ListNode p1Next = p1.next;
            ListNode p2Next = p2.next;
            
            p2.next = p1.next;
            p1.next = p2;
            
            p1 = p1Next;
            p2 = p2Next;
        }
        
    }  

    ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        
        return dummy.next;
    }
}
