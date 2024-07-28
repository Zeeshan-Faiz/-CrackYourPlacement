package Tree.EasyQuestions;

import java.util.ArrayList;
import java.util.List;

import Tree.EasyQuestions.Q101SymmetricTree.TreeNode;

/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
*/

public class Q94BinaryTreeInorderTraversal {
    
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();

        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);

        return ans;
    }
}