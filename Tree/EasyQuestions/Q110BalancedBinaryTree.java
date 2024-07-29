package Tree.EasyQuestions;

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
        // If the tree is empty, we can say it’s balanced...
        if (root == null)
            return true;
        // Height Function will return -1, when it’s an unbalanced tree...
        if (findHeight(root) == -1)
            return false;
        return true;
    }
}