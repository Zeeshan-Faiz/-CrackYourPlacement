package LinkedList.EasyQuestions;

/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list 
that has Node.val == val, and return the new head.

Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []
*/

public class Q203RemoveLinkedListElements {
    
    public ListNode removeElements(ListNode head, int val) {

        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        temp.next = head;//dummy node added before head of the given list
        while(curr.next != null){
            if(curr.next.val == val){
                curr.next = curr.next.next;
            }
            else
                curr = curr.next;
        }
        return temp.next; //the actual head of the list is returned
    }

    public class ListNode {
        
        int val;
        ListNode next;

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