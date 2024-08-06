package StackAndQueues.MediumQuestions;

import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures, return an array 
answer such that answer[i] is the number of days you have to wait after the ith day to get a 
warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 
instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
*/

public class Q739DailyTemperature {
    
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for (int idx = n - 1; idx >= 0; idx--) {

            // Pop all indices with a lower or equal temperature than the current index
            while (!stack.isEmpty()
                    && temperatures[idx] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            // If the stack still has elements, then the next warmer temperature exists!
            if (!stack.isEmpty()) {
                result[idx] = stack.peek() - idx;
            }

            // Inserting current index in the stack
            stack.push(idx);
        }
        return result;
    }
}