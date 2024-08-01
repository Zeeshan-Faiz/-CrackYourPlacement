package Tree.MediumQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parent_check = new HashMap<>();
        setparent(root, parent_check);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        int level = 0;
        while (!q.isEmpty()) 
        {
            int size = q.size();
            if (level == k) {
                break;
            }
            level++;

            for (int i = 0; i < size; i++) 
            {
                TreeNode temp = q.poll();
                if (temp.left != null && visited.get(temp.left) == null) {
                    q.add(temp.left);
                    visited.put(temp.left, true);
                }
                if (temp.right != null && visited.get(temp.right) == null) {
                    q.add(temp.right);
                    visited.put(temp.right, true);
                }
                if (parent_check.get(temp) != null && visited.get(parent_check.get(temp)) == null) {
                    q.add(parent_check.get(temp));
                    visited.put(parent_check.get(temp), true);

                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            res.add(curr.val);
        }
        return res;
    }

    public void setparent(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) 
        {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parent_track.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent_track.put(curr.right, curr);
                q.add(curr.right);
            }
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