package edu.usc.demiguise.datastructure;


import edu.usc.demiguise.utils.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class _145_binary_tree_postorder_traversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> postorder = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        if (root != null) {
            stack.push(root);
        }

        TreeNode prev = null, curr = root;
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                postorder.add(curr.val);
                stack.pop();
            }

            prev = curr;
        }

        return postorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        _145_binary_tree_postorder_traversal solution = new _145_binary_tree_postorder_traversal();
        solution.postorderTraversal(root);
    }
}
