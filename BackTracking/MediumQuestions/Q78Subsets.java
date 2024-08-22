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
        
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums, int start) {
        
        // Add the set to list
        resultSets.add(new ArrayList<>(tempSet));
        for (int i = start; i < nums.length; i++) 
        {
            // pick the element
            tempSet.add(nums[i]);
            backtrack(resultSets, tempSet, nums, i + 1);

            // backtrack and remove the picked element
            tempSet.remove(tempSet.size() - 1);
        }
    }
}