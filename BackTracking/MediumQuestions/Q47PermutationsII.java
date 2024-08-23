package BackTracking.MediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique 
permutations in any order.

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
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], ans, new ArrayList<>());
        return ans;
    }

    private void helper(int[] nums, boolean[] used, List<List<Integer>> ans, ArrayList<Integer> list) {

        if (list.size() == nums.length && (!ans.contains(list))) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip if we get same element
            if (used[i])
                continue;

            list.add(nums[i]);
            used[i] = true;

            helper(nums, used, ans, list);
            // Backtrack and Remove the picked element
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}