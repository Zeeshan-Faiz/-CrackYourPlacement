package StackAndQueues.MediumQuestions;

import java.util.Stack;

/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k 
adjacent and equal letters from s and removing them, causing the left and the right side of 
the deleted substring to concatenate together. We repeatedly make k duplicate removals on s 
until we no longer can.
Return the final string after all such duplicate removals have been made. It is guaranteed 
that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
*/

public class Q1209RemoveAllAdjacentDuplicatesII {
    
    public String removeDuplicates(String s, int k) {
        
        Stack<int[]> stack = new Stack<>();
        for (char ch : s.toCharArray()) 
        {
            //increase frequency of the character in stack
            if (!stack.isEmpty() && stack.peek()[0] == ch)
                stack.peek()[1]++;
            else
                //add new character with frequency 1 in the stack
                stack.push(new int[] { ch, 1 });

            //if frequency equals k remove the character
            if (stack.peek()[1] == k)
                stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) 
        {
            int[] top = stack.pop();
            while (top[1] > 0){
                //add all elements occurred less than k time together
                sb.append((char) top[0]);
                top[1]--;
            }
        }
        return sb.reverse().toString();
    }
}