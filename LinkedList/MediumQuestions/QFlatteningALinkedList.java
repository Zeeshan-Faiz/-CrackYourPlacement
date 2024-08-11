package LinkedList.MediumQuestions;

/*
Given a Linked List, where every ListNode represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next ListNode,
(ii) a bottom pointer to a linked list where this ListNode is head.
Each of the sub-linked lists is in sorted order.
Flatten the Link List so all the ListNodes appear in a single level while maintaining the sorted 
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
Explanation: The resultant linked lists has every ListNode in a single level.(Note: | represents the bottom pointer.)
*/

public class QFlatteningALinkedList {
    
    ListNode flatten(ListNode root) {
        
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

    ListNode mergeTwoLists(ListNode a, ListNode b) {
        
        ListNode temp = new ListNode(0);
        ListNode res = temp; 
        
        while(a != null && b != null) 
        {
            if(a.val < b.val) {
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
        temp.bottom = (a != null) ? a : b; 
        return res.bottom; 
    }

    public class ListNode {
        
        int val;
        ListNode next;
        ListNode bottom;

        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}