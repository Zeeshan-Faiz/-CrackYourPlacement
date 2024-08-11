package HeapPriorityQueue.MediumQuestions;

import java.util.HashMap;

/*
Given an array having both positive and negative integers. The task is to compute the 
length of the largest subarray with sum 0.

Example 1:
Input: arr[] = {15,-2,2,-8,1,7,10,23}, n = 8
Output: 5
Explanation: The largest subarray with sum 0 is -2 2 -8 1 7.

Example 2:
Input: arr[] = {2,10,4}, n = 3
Output: 0
Explanation: There is no subarray with 0 sum.

Example 3:
Input: arr[] = {1, 0, -4, 3, 1, 0}, n = 6
Output: 5
Explanation: The subarray is 0 -4 3 1 0.
*/

public class QLargestSubArrayWith0Sum {

    public int maxLen(int arr[], int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int length = 0, sum = 0;
        for (int i = 0; i < n; i++) 
        {
            sum = sum + arr[i];
            if (sum == 0)
                length = i + 1; // if sum equals 0 store the length
            else {
                if (map.get(sum) != null)
                    // if map already has a previous sum then the middle subarray between previous
                    // sum 0 and current sum 0 is the length
                    length = Math.max(length, i - map.get(sum));
                else
                    // add current prefix sum in map
                    map.put(sum, i);
            }
        }
        return length;
    }
}