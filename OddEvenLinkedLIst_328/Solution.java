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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } 
        
        ListNode oddHeadDummy = new ListNode(0);
        oddHeadDummy.next = head;
        
        ListNode evenHeadDummy = new ListNode(0);
        evenHeadDummy.next = head.next;
        
        ListNode curr = head;
        
        ListNode lastOdd = oddHeadDummy.next;
        ListNode lastEven = evenHeadDummy.next;
        
        int turn = 1;
        
        while (curr != null) {
            ListNode next = curr.next;
          
            if (turn % 2 == 1) {
               lastOdd.next = curr;
               lastOdd = curr;
            }
            else {
               lastEven.next = curr;
               lastEven = curr;
            }
            
            turn++;
            curr = next;
        }
        
        lastOdd.next = evenHeadDummy.next;
        lastEven.next = null;
        
        return oddHeadDummy.next;
    }
    
    
}
