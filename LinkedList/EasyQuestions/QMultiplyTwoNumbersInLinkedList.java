package LinkedList.EasyQuestions;

import org.w3c.dom.Node;

/*
Given two numbers represented by linked lists, write a function that returns the 
multiplication of these two linked lists.

Example 1:
Input : 9->4->6
        8->4
Output : 79464

Input : 3->2->1
        1->2
Output : 3852
*/

public class QMultiplyTwoNumbersInLinkedList {

    // Multiply contents of two linked lists
    static long multiplyTwoLists(Node first, Node second) {
        long N = 1000000007;
        long num1 = 0, num2 = 0;

        while (first != null || second != null) {

            if (first != null) {
                num1 = ((num1) * 10) % N + first.data;
                first = first.next;
            }

            if (second != null) {
                num2 = ((num2) * 10) % N + second.data;
                second = second.next;
            }

        }
        return ((num1 % N) * (num2 % N)) % N;
    }
}