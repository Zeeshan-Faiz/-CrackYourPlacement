package Array.MediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible 
unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/

public class Q47PermutationsII {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        helper(resultList, new ArrayList<>(), nums, new boolean[nums.length]);
        return resultList;
    }

    private void helper(List<List<Integer>> resultList, ArrayList<Integer> tempList, int[] nums, boolean[] used) {
        
        // If we match the length, it is a permutation
        if (tempList.size() == nums.length && !resultList.contains(tempList)) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) 
        {
            // Skip if we get same element
            if (used[i])
                continue;

            // Add the new element and mark it as used
            used[i] = true;
            tempList.add(nums[i]);

            // Go back to try other element
            helper(resultList, tempList, nums, used);

            // Remove the element and mark it as unused
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}