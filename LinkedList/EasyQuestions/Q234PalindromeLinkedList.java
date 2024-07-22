package LinkedList.EasyQuestions;

import LinkedList.EasyQuestions.Q876MiddleOfLinkedList.ListNode;

/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false
*/

public class Q234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        // Approach : Find the middle node and reverse the 2nd half of the list and compare it with
        // the first half to find palindrome
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                return false;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);// bring back the original list

        return true;
    }

    // finding the middle node
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    // reversing a list
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}