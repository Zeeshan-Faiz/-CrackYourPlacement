package LinkedList.MediumQuestions;

/*
Given the head of a linked list and a value x, partition it such that all nodes less than x 
come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
*/

public class Q86PartitionList {

    public ListNode partition(ListNode head, int x) {
        
        ListNode smallList = new ListNode(0);
        ListNode bigList = new ListNode(0);
        ListNode smallHead = smallList, bigHead = bigList;

        while (head != null) 
        {
            if (head.val < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
            } 
            else {
                bigHead.next = head;
                bigHead = bigHead.next;
            }
            head = head.next;
        }
        smallHead.next = bigList.next;
        bigHead.next = null;

        return smallList.next;
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