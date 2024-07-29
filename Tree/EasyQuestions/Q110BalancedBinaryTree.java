package Tree.EasyQuestions;

import Tree.EasyQuestions.Q101SymmetricTree.TreeNode;

/*
Given a binary tree, determine if it is height-balanced.
A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every \
node never differs by more than one.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true.
*/

public class Q110BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        
        if (root == null)
            return true;
        
        if (findHeight(root) == -1)
            return false;

        return true;
    }

    public int findHeight(TreeNode root) {

        if (root == null)
            return 0;

        // find height of left & rightsubtree...
        int leftHeight = findHeight(root.left);
        int rightHight = findHeight(root.right);
        // In case of left or right subtree unbalanced, or heights differ by more than ‘1’, return -1
        if ((leftHeight == -1 || rightHight == -1) || (Math.abs(leftHeight - rightHight) > 1))
            return -1;

        return Math.max(leftHeight, rightHight) + 1;
    }
}