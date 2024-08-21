package BackTracking.MediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique 
combinations in candidates where the candidate numbers sum to target. Each number in candidates 
may only be used once in the combination. Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[[1,1,6],[1,2,5],[1,7],[2,6]]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[[1,2,2],[5]]
*/

public class Q40CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> list) {
        
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = ind; i < arr.length; i++) 
        {
            if (i > ind && arr[i] == arr[i - 1])
                continue;//skip the similar element
            if (arr[i] > target)
                break;

            list.add(arr[i]);
            helper(i + 1, arr, target - arr[i], ans, list);
            list.remove(list.size() - 1);//backtrack and remove the selected elements
        }
    }
}