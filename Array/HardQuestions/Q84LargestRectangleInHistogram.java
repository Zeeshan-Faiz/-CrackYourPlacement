package Array.HardQuestions;

import java.util.Stack;

/*
Given an array of integers heights representing the histogram's bar height where the width of each 
bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
*/

public class Q84LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        stack.push(0);

        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        int i = heights.length;
        while (!stack.isEmpty()) {
            max = getMax(heights, stack, max, i);
        }

        return max;
    }

    private static int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
        
        int area;
        int popped = stack.pop();
        if (stack.isEmpty()) {
            area = arr[popped] * i;
        } else {
            area = arr[popped] * (i - 1 - stack.peek());
        }
        return Math.max(max, area);
    }
}