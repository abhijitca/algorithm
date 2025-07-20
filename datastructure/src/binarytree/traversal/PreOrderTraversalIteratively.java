package binarytree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalIteratively {
    static class TreeNode {
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

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        postOrderTraversalRecursively(root);
    }

    private static List<Integer> postOrderTraversalRecursively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode no = stack.pop();
                list.add(no.val);
                if (no.right != null) stack.add(no.right);
                if (no.left != null) stack.add(no.left);
            }
        }
        return list;

    }


}
