package binarytree.traversal;

import java.util.*;

public class RightView {
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
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);


        rightView(root).forEach(t -> System.out.println(t));
    }

    private static List<Integer> rightView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                if (i == size - 1) list.add(que.peek().val);
                if (que.peek().left != null) que.add(que.peek().left);
                if (que.peek().right != null) que.add(que.peek().right);

                que.poll();
            }
        }
        return list;
    }
}
