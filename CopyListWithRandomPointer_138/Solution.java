/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        
        Node curr = head;
        
        while (curr != null) {
            Node next = curr.next;
            
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
                   
            curr = next;
        }
        
        // second pass for random pointer
        Node orig = head;
        Node copied = head.next;
        
        while (copied.next != null) {
            
            if (orig.random == null) {
                copied.random = null;
            }
            else {
                copied.random = orig.random.next;
            }
            
            orig = orig.next.next;
            copied = copied.next.next;
        }
        
        // process last node
        if (copied != null) {
        
            if (orig.random == null) {
                copied.random = null;
            }
            else {
                copied.random = orig.random.next;
            }
        }
        
        Node newHead = head.next;

        Node prev = head;
        curr = head.next;
        while (curr.next != null) {
            Node next = curr.next;
            
            prev.next = curr.next;
            curr.next = curr.next.next;
            
            prev = next;
            curr = next.next;
        }
        
        if (curr != null) {
            prev.next = null;
        }
        
        return newHead;
        
    }
}
