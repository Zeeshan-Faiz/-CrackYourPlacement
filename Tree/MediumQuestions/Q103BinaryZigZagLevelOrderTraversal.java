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
            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < size; i++) 
            {
                TreeNode node = queue.poll();
                
                if (leftToRight)
                    row.add(node.val); // Append to the end
                else
                    row.add(0, node.val); // Insert at the beginning

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // Switch the traversal direction for the next level
            leftToRight = !leftToRight;
            result.add(row);
        }
        return result;
    }
}