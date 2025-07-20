package binarytree.depth;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.left.right.left = new TreeNode(6);
//        root.left.right.right = new TreeNode(7);

//        System.out.println(calculateMaxDepth(root));

//        System.out.println(inorderTraversal(root, 1, 0));

        System.out.println(getHeightByRecursion(root));
    }

    private static int getHeightByRecursion(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(getHeightByRecursion(root.left), getHeightByRecursion(root.right));
    }

    private static int inorderTraversal(TreeNode root, int depth, int max) {
        if (root == null) {
            max = Math.max(depth, max);
            return max - 1;
        }
        int max1 = inorderTraversal(root.left, depth + 1, max);
        int max2 = inorderTraversal(root.right, depth + 1, max);
        return max1 > max2 ? max1 : max2;
    }

    private static int calculateMaxDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        if (root == null) return 0;
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            depth = depth + 1;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
        }
        return depth;
    }
}
