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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        ListNode p1 = l1;
        while (p1 != null) {
            s1.push(p1.val);
            p1 = p1.next;
        }
        
        ListNode p2 = l2;
        while (p2 != null) {
            s2.push(p2.val);
            p2 = p2.next;
        }
        
        ListNode dummy = new ListNode(0);
        int carry = 0;
        
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            
            int sum = a + b + carry;
            carry = sum / 10;
            
            ListNode node = new ListNode(sum % 10);
            // add at begining
            node.next = dummy.next;
            dummy.next = node;
        }
        
    
        return dummy.next;
    }
}
