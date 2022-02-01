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
   public ListNode swapNodes(ListNode head, int k) {
    int length = 0;
    for (ListNode node = head; node != null; node = node.next) 
        length++;
    
    ListNode sentinel = new ListNode(0);
    sentinel.next = head;
    
    ListNode first = sentinel;
    ListNode second = head;
    int index = 1;
    int maxRange = Math.max(k, length-k+1);
    
    for (ListNode node = sentinel; index <= maxRange; node = node.next, index++) {
        if (index == k)
            first = node;
        if (index == length-k+1)
            second = node;
    }
    
    // if both are the same nodes, (i.e: first == second)
    if (k == length-k+1)
        return head;
    // if first is further than second, 
    // we need to swap the references since it's a singly linked list
    else if (k > length-k+1) {
        ListNode node = first;
        first = second;
        second = node;
    }
    
    swapNextNodes(first, second);
    return sentinel.next;
}

private void swapNextNodes(ListNode first, ListNode second) {
    ListNode next1 = first.next;
    ListNode next2 = second.next;
    
    ListNode nextNext1 = next1.next;
    ListNode nextNext2 = next2.next;
    
    // if they are consecutive
    if (first.next == second) {
        first.next = next2;
        next2.next = next1;
        next1.next = nextNext2;
    }
    // if they are not consecutive
    else {
        first.next = next2;
        next2.next = nextNext1;
        
        second.next = next1;
        next1.next = nextNext2;
    }
}
}
