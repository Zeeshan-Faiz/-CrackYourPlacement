package BackTracking.MediumQuestions;

/*
Given an integer array nums and an integer k, return true if it is possible to divide this array 
into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Example 2:
Input: nums = [1,2,3,4], k = 3
Output: false
*/

public class Q698PartitionToKEqualSubSetSum {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int totalSum = 0;
        for (int el : nums) {
            totalSum += el;
        }

        if (totalSum % k != 0 || nums.length < k) {
            return false;
        }

        int subsetSum = totalSum / k;
        boolean[] visited = new boolean[nums.length];
        
        return helper(nums, visited, 0, k, 0, subsetSum);
    }

    private boolean helper(int[] nums, boolean[] visited, int start, int k, int curSum, int subsetSum) {
        
        if (k == 0)
            return true;
        if (curSum > subsetSum)
            return false;

        //if curSum equals subsetSum, we'll go for filling the next bucket
        if (curSum == subsetSum)
            return helper(nums, visited, 0, k - 1, 0, subsetSum);
    
        for (int i = start; i < nums.length; i++) 
        {
            if (visited[i])
                continue;
            visited[i] = true;
            if (helper(nums, visited, i + 1, k, curSum + nums[i], subsetSum))
                return true;
            visited[i] = false;//backtrack and unmark the element
        }
        return false;
    }
}