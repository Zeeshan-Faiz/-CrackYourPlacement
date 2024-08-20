package Tree.MediumQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
(i.e., from left to right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
*/

public class Q103BinaryZigZagLevelOrderTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Flag to determine the direction of traversal (left to right or right to left)
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < size; i++) 
            {
                TreeNode temp = queue.poll();
                
                if (leftToRight)
                    ans.add(temp.val); // Append to the end
                else
                    ans.add(0, temp.val); // Insert at the beginning

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            // Switch the traversal direction for the next level
            leftToRight = !leftToRight;
            result.add(ans);
        }
        return result;
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