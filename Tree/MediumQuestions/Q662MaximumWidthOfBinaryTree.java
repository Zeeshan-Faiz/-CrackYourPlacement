package Tree.MediumQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels. The width of one level is 
defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where 
the null nodes between the end-nodes that would be present in a complete binary tree extending 
down to that level are also counted into the length calculation.
It is guaranteed that the answer will in the range of a 32-bit signed integer.

Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).

Example 2:
Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).

Example 3:
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
*/

public class Q662MaximumWidthOfBinaryTree {
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 1;
        }

        int maxWidth = 0;
        // <Nodee, Weight>
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 0);
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int size = qu.size();
            int left = map.get(qu.peek());//
            while (size-- > 0) {
                TreeNode head = qu.poll();
                maxWidth = Math.max(maxWidth, map.get(head) - left + 1);
                if (head.left != null) {
                    qu.offer(head.left);
                    map.put(head.left, 2 * map.get(head));
                }

                if (head.right != null) {

                    qu.offer(head.right);
                    map.put(head.right, 2 * map.get(head) + 1);
                }
            }
        }
        return maxWidth;
    }
}