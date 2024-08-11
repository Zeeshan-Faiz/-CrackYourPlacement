package LinkedList.EasyQuestions;

import org.w3c.dom.Node;

/*
Given a linked list of 0s, 1s and 2s, The task is to sort and print it.

Example 1:
Input: 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> NULL 
Output: 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2 -> NULL

Input: 1 -> 1 -> 2 -> 1 -> 0 -> NULL 
Output: 0 -> 1 -> 1 -> 1 -> 2 -> NULL
*/

public class QSortLinkedListOf0s1s2s {
    
    static Node sortList(Node head) {
        
        if (head == null || head.next == null) 
            return head; 

        // Create three dummy nodes to point to beginning of three linked lists.
        Node zeroHead = new Node(0); 
        Node oneHead = new Node(0); 
        Node twoHead = new Node(0);

        // Initialize current pointers for three lists 
        Node zero = zeroHead, one = oneHead, two = twoHead; 
        Node curr = head; 
        while (curr != null) 
        { 
            if (curr.data == 0) { 
                // If the data of current node is 0, append it to pointer zero and update zero
                zero.next = curr; 
                zero = zero.next; 
            } 
            else if (curr.data == 1) {  
                // If the data of current node is 1, append it to pointer one and update one
                one.next = curr; 
                one = one.next; 
            } 
            else { 
                // If the data of current node is 2, append it to pointer two and update two
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
}