package Tree.MediumQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, return all the structurally unique BST's (binary search trees), which 
has exactly n nodes of unique values from 1 to n. Return the answer in any order.

Example 1:
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

Example 2:
Input: n = 1
Output: [[1]]
*/

public class Q95UniqueBinarySearchTreesII {
    
    public List<TreeNode> generateTrees(int n) {

        if (n <= 0)
            return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> all_trees = new ArrayList<>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left_trees = helper(start, i - 1);
            List<TreeNode> right_trees = helper(i + 1, end);

            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree);
                }
            }
        }
        return all_trees;
    }
}