package Tree.MediumQuestions;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Given the root of a binary tree, the value of a target node target, and an integer k, return 
an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.

Example 2:
Input: root = [1], target = 1, k = 3
Output: []
*/

public class Q863AllNodesDistanceK {

    public void setparent(TreeNode root, Map<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {

            int size = q.size();

            TreeNode temp = q.poll();
            if (temp.left != null) {
                map.put(temp.left, temp);
                q.add(temp.left);
            }
            if (temp.right != null) {
                map.put(temp.right, temp);
                q.add(temp.right);
            }

        }
    }
}