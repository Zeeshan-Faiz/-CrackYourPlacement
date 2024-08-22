package BackTracking.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range 
[1, n]. You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
*/

public class Q77Combinations {
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(n, k, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int n, int k, List<List<Integer>> ans, List<Integer> list) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (n == 0)
            return;

        // pick
        list.add(n);
        helper(n - 1, k - 1, ans, list);
        list.remove(list.size() - 1);// backtrack to remove the current element

        // not pick
        helper(n-1, k, ans, list);
    }
}