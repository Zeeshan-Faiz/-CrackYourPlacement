package Tree.MediumQuestions;

/*
Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a 
binary tree of distinct values and postorder is the postorder traversal of the same tree, 
reconstruct and return the binary tree. If there exist multiple answers, you can return any of them.

Example 1:
Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

Example 2:
Input: preorder = [1], postorder = [1]
Output: [1]
*/

public class Q889ConstructBTfromPreAndPostOrder {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int startPre, int endPre, int[] postorder, int startPost,
            int endPost) {
        // Base case: if the start index exceeds the end index, return null
        if (startPre > endPre || startPost > endPost) {
            return null;
        }

        // The first element in preorder is the root
        TreeNode root = new TreeNode(preorder[startPre]);

        // If there is only one element, return the root
        if (startPre == endPre) {
            return root;
        }

        // Find the boundary of the left subtree
        int index = startPost;
        while (index < endPost) {
            if (preorder[startPre + 1] == postorder[index]) {
                break;
            }
            index++;
        }

        // Recursively construct the left and right subtrees
        root.left = construct(preorder, startPre + 1, startPre + index - startPost + 1, postorder, startPost, index);
        root.right = construct(preorder, startPre + index - startPost + 2, endPre, postorder, index + 1, endPost - 1);

        return root;
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