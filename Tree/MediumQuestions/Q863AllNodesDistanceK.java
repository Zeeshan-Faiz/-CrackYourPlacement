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

        Map<TreeNode, TreeNode> map = new HashMap<>();
        setparent(root, map);
        Map<TreeNode, Boolean> check = new HashMap<>();
        check.put(target, true);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k) {
                break;
            }
            level++;

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null && check.get(temp.left) == null) {
                    q.add(temp.left);
                    check.put(temp.left, true);

                }
                if (temp.right != null && check.get(temp.right) == null) {
                    q.add(temp.right);
                    check.put(temp.right, true);
                }
                if (map.get(temp) != null && check.get(map.get(temp)) == null) {
                    q.add(map.get(temp));
                    check.put(map.get(temp), true);

                }

            }
        }
        List<Integer> mc = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode help = q.poll();
            mc.add(help.val);
        }

        return mc;
    }

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