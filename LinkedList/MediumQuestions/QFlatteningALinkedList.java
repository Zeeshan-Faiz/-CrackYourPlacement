package LinkedList.MediumQuestions;

/*
Given a Linked List, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked lists is in sorted order.
Flatten the Link List so all the nodes appear in a single level while maintaining the sorted 
order.
Note: The flattened list will be printed using the bottom pointer instead of the next pointer. Look at the printList() function in the driver code for more clarity.

Example 1:
    5-> 10 -> 19 -> 28
    |   |     |     |
    7   20    22    35
    |         |     |    
    8         55    40
    |               |
    30              45
Output:  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation: The resultant linked lists has every node in a single level.(Note: | represents the bottom pointer.)
*/

public class QFlatteningALinkedList {
    
    Node flatten(Node root) {
        
        // recurse until you reach the last list
        if (root == null || root.next == null) 
                return root; 
      
            // recur for list on right 
            root.next = flatten(root.next); 
      
            // now merge previous list with the current list
            root = mergeTwoLists(root, root.next); 
      
            // return the root it will be in turn merged with its left 
            return root; 
    }

    Node mergeTwoLists(Node a, Node b) {
        
        Node temp = new Node(0);
        Node res = temp; 
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.bottom = a; 
                temp = temp.bottom; 
                a = a.bottom; 
            }
            else {
                temp.bottom = b;
                temp = temp.bottom; 
                b = b.bottom; 
            }
        }
        
        if(a != null) temp.bottom = a; 
        else temp.bottom = b;
        return res.bottom; 
    
    }
}