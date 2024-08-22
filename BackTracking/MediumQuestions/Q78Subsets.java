package BackTracking.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
*/

public class Q78Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int ind, int[] nums, List<List<Integer>> ans, List<Integer> list) {

        if (ind == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // pick the element
        list.add(nums[ind]);
        helper(ind + 1, nums, ans, list);
        list.remove(list.size() - 1);// backtrack and remove the picked element

        helper(ind + 1, nums, ans, list);
    }
}