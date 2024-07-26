package LinkedList.MediumQuestions;

import java.util.Stack;

/*
You are given two non-empty linked lists representing two non-negative integers. The most 
significant digit comes first and each of their nodes contains a single digit. Add the two 
numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

Example 2:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

Example 3:
Input: l1 = [0], l2 = [0]
Output: [0]
*/

public class Q445AddTwoNumbersII {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        // add each node from both lists to two separate stacks
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummyHead = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) 
        {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop();
            int val2 = stack2.isEmpty() ? 0 : stack2.pop();
            int total = val1 + val2 + carry;
            carry = total / 10;
            ListNode new_node = new ListNode(total % 10);
            new_node.next = dummyHead;
            dummyHead = new_node;
        }
        return dummyHead;
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