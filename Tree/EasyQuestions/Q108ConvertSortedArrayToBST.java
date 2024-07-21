package Tree.EasyQuestions;

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced
binary search tree.

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
*/

public class Q108ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return CreateBST(nums, 0, nums.length - 1);
    }

    private TreeNode CreateBST(int nums[], int l, int r) {

        if (l > r)
            return null;

        // we take middle element as head value such that it will become height balanced tree
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // assign nodes to left of subtree
        root.left = CreateBST(nums, l, mid - 1);

        // assign nodes to right of subtree
        root.right = CreateBST(nums, mid + 1, r);

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