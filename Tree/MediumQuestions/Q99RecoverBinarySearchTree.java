package Tree.MediumQuestions;

/*
You are given the root of a binary search tree (BST), where the values of exactly two nodes of 
the tree were swapped by mistake. Recover the tree without changing its structure.

Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
*/

public class Q99RecoverBinarySearchTree {

    private TreeNode first, prev, middle, last;

    public void recoverTree(TreeNode root) {

        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        // 1st violation case
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }

        // 2nd violation case
        if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void inorder(TreeNode root) {
        
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null && (root.val < prev.val)) {
            // if second violation case
            if (first == null) {
                first = prev;
                middle = root;
            }
            // if first violation case
            else
                last = root;
        }
        prev = root;
        inorder(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}