package BackTracking.MediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
*/

public class Q90SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        sub(0, nums, ans, new ArrayList<>());
        return ans;
    }

    public void sub(int ind, int[] nums, List<List<Integer>> ans, List<Integer> list) {

        ans.add(new ArrayList<>(list));
        for (int i = ind; i < nums.length; i++) 
        {
            // skip duplicate elements
            if (i > ind && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            sub(i + 1, nums, ans, list);
            list.remove(list.size() - 1);// backtrack and remove the selected elements
        }
    }
}