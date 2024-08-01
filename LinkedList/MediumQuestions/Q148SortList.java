package LinkedList.MediumQuestions;

/*
Given the head of a linked list, return the list after sorting it in ascending order.

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []
*/

public class Q148SortList {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        ListNode res = mergeTwoLists(left, right);
        return res;
    }

    public ListNode findMid(ListNode head) {
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    
}