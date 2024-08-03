package LinkedList.MediumQuestions;

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list. Return the linked list sorted as well.

Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]
*/

public class Q82RemoveDuplicatesFromSortedListII {
    
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next== null) 
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(head != null) 
        {
            if(head.next != null && head.val == head.next.val)
            {
                //skip the nodes whose values are equal to head.
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                prev.next = head.next;
            }
            else
                prev = prev.next;
    
            head = head.next;
        }
        return dummy.next;
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