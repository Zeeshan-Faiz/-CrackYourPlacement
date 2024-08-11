package LinkedList.EasyQuestions;

/*
Given a linked list of 0s, 1s and 2s, The task is to sort and print it.

Example 1:
Input: 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> NULL 
Output: 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2 -> NULL

Input: 1 -> 1 -> 2 -> 1 -> 0 -> NULL 
Output: 0 -> 1 -> 1 -> 1 -> 2 -> NULL
*/

public class QSortLinkedListOf0s1s2s {
    
    public ListNode sortList(ListNode head) {
        
        if (head == null || head.next == null) 
            return head; 

        // Create three dummy ListNodes to point to beginning of three linked lists.
        ListNode zeroHead = new ListNode(0);
        ListNode oneHead = new ListNode(0); 
        ListNode twoHead = new ListNode(0);

        // Initialize current pointers for three lists 
        ListNode zero = zeroHead, one = oneHead, two = twoHead; 
        ListNode curr = head; 
        while (curr != null) 
        { 
            if (curr.val == 0) { 
                // If the data of current ListNode is 0, append it to pointer zero and update zero
                zero.next = curr; 
                zero = zero.next; 
            } 
            else if (curr.val == 1) {  
                // If the data of current ListNode is 1, append it to pointer one and update one
                one.next = curr; 
                one = one.next; 
            } 
            else { 
                // If the data of current ListNode is 2, append it to pointer two and update two
                two.next = curr; 
                two = two.next; 
            } 
            curr = curr.next; 
        } 

        // Combine the three lists
        zero.next = (oneHead.next != null) ? (oneHead.next) : (twoHead.next); 
        one.next = twoHead.next; 
        two.next = null; 
          
        // Updated head 
        head = zeroHead.next; 
        return head; 
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