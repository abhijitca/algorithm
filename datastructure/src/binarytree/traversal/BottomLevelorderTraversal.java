package binarytree.traversal;

import java.util.*;

public class BottomLevelorderTraversal {
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

        bottomLevelOrder(root);
    }

    private static List<List<Integer>> bottomLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<List<Integer>> ls = new Stack<>();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ls1 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                ls1.add(queue.poll().val);
            }
            ls.add(ls1);
        }
        while (!ls.isEmpty()) {
            list.add(ls.pop());
        }
        return list;
    }
}
