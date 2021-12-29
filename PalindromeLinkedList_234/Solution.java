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
    private ListNode ref;
    public boolean isPalindrome(ListNode head) {
        ref = head;
        
        return isPalindromeHelper(head);
    }
    
    public boolean isPalindromeHelper(ListNode head) {
        if (head == null) {
            return true;
        }
        
        boolean rest = isPalindromeHelper(head.next);
        boolean equal = head.val == ref.val;
        
        ref = ref.next;
        
        return rest && equal;
    }
}
