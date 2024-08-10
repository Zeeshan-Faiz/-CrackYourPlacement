package LinkedList.MediumQuestions;

/*
Given the head of a singly linked list, group all the nodes with odd indices together followed 
by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on. Note that the relative 
order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
*/

public class Q328OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if (head == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            // Change pointers for odd list
            odd.next = odd.next.next;
            odd = odd.next;

            // Change pointers for even list
            even.next = even.next.next;
            even = even.next;
        }
        // Assign even list at the end of odd list
        odd.next = evenHead;
        return head;
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