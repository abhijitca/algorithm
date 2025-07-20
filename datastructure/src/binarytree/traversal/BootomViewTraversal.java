package binarytree.traversal;

import javafx.util.Pair;

import java.util.*;

public class BootomViewTraversal {
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
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);

        showBottomNode(root);
    }

    private static void showBottomNode(TreeNode root) {
        Map<Integer, TreeNode> hm = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> p = queue.peek();
                if (p.getKey().left != null) {
                    queue.add(new Pair<>(p.getKey().left, p.getValue() - 1));
                }
                if (p.getKey().right != null) {
                    queue.add(new Pair<>(p.getKey().right, p.getValue() + 1));
                }
                Pair<TreeNode, Integer> p1 = queue.poll();
                hm.put(p1.getValue(), p1.getKey());
            }
        }
        System.out.println(hm);
    }
}
