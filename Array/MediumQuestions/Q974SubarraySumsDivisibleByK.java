package Array.MediumQuestions;

import java.util.HashMap;

/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that 
have a sum divisible by k. A subarray is a contiguous part of an array.

Example 1:
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Example 2:
Input: nums = [5], k = 9
Output: 0
*/

public class Q974SubarraySumsDivisibleByK {
    
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> prefixsum = new HashMap<>();
        prefixsum.put(0, 1);

        int count = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // remainder is present in hashmap it means in between the sum is divisible by k
            int target = sum % k;
            if (target < 0)
                target += k; // it is in minus it means sum in negative

            if (prefixsum.containsKey(target))
                count += prefixsum.get(target);

            prefixsum.put(target, prefixsum.getOrDefault(target, 0) + 1);

        }
        return count;
    }
}