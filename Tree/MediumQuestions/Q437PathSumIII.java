package Tree.MediumQuestions;

import java.util.HashMap;

/*
Given the root of a binary tree and an integer targetSum, return the number of paths where 
the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards 
(i.e., traveling only from parent nodes to child nodes).

Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.

Example 2:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
*/

public class Q437PathSumIII {
    
    int count = 0;
    int k;
    HashMap<Long, Integer> h = new HashMap();

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0);
        return count;
    }

    public void preorder(TreeNode node, long currSum) {
        if (node == null)
            return;
        currSum += node.val;
        if (currSum == k)
            count++;

        //count the prefix sum
        count += h.getOrDefault(currSum - k, 0);
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        preorder(node.left, currSum);
        preorder(node.right, currSum);

        // backtrack once you reach leaf node
        h.put(currSum, h.get(currSum) - 1);
    }
}