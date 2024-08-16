package Array.MediumQuestions;

/*
Given an integer array nums, return true if you can partition the array into two subsets such 
that the sum of the elements in both subsets is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
*/

public class Q416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        for (int n : nums)
            totalSum += n;

        if (totalSum % 2 != 0)
            return false;

        int subSetSum = totalSum / 2;
        Boolean[][] dp = new Boolean[nums.length][subSetSum + 1];

        return dfs(1, subSetSum, nums, dp);
    }

    public boolean dfs(int idx, int subSetSum, int[] nums, Boolean[][] dp) {
        
        if (subSetSum == 0)
            return true;

        if (idx == nums.length || subSetSum < 0)
            return false;

        if (dp[idx][subSetSum] != null)
            return dp[idx][subSetSum];

        //take current element or skip it
        boolean result = dfs(idx + 1, subSetSum - nums[idx], nums, dp) ||
                dfs(idx + 1, subSetSum, nums, dp);

        return dp[idx][subSetSum] = result;
    }
}