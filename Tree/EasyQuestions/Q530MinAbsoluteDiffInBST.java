package Tree.EasyQuestions;

import Tree.EasyQuestions.Q101SymmetricTree.TreeNode;

/*
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between 
the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
*/

public class Q530MinAbsoluteDiffInBST {
    
    Integer prev = null;
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        
        if (root == null)
            return 0;

        //We'll do in order traversal as it's a BST and in-order will product sorted nodes

        // Traverse the left subtree
        getMinimumDifference(root.left);

        // Update minDiff and prev value when not at the first node
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;

        // Traverse the right subtree
        getMinimumDifference(root.right);

        return minDiff;
    }
}