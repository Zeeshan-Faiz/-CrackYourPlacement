package Tree.MediumQuestions;

/*
Given the root of a binary tree, flatten the tree into a "linked list":
    The "linked list" should use the same TreeNode class where the right child pointer points to 
    the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []
*/

public class Q114FlattenBinaryTreeToLinkedList {
    
    public void flatten(TreeNode root) {
        
        TreeNode curr = root;
        while (curr != null) 
        {
            // Check if the current node has a left child
            if (curr.left != null) {
                // If yes, find the rightmost node in the left subtree
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                // Connect the rightmost node in the left subtree to the current node's right child
                pre.right = curr.right;

                // Move the entire left subtree to the right child of the current node
                curr.right = curr.left;

                // Set the left child of the current node to NULL
                curr.left = null;
            }
            // Move to the next node on the right side
            curr = curr.right;
        }
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