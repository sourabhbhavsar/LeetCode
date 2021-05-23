/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        
         Node newNode = new Node(insertVal);
        
        // special case
        if (head == null) {       
            newNode.next = newNode;
            head = newNode;
            
            return head;
        }   
        
        Node prev = head;
        Node curr = head;
        Node max = head;
        
        while (true) {
            prev = curr;
            curr = curr.next;
            
            if (curr.val <= insertVal && curr.next.val >= insertVal) 
            {
                newNode.next = curr.next;
                curr.next = newNode;
                
                return head;
            }
            
            if (curr.val >= max.val) {
                max = curr;
            }
            
            // if the inserVal will be the new min or new max
            // it will always be added after the original max value of the
            // unmodified list.
            
            // we have traversed all the list.
            if (curr == head) {
                newNode.next = max.next;
                max.next = newNode;
                
                return head;
            }
        }
    }
}
