package binarytree.depth;

import binarytree.traversal.LevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthInLeftAndRight {
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
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.right = new TreeNode(3);
                TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.right = new TreeNode(6);

//        System.out.println(calculateMaxDepth(root));

//        System.out.println(inorderTraversal(root, 1, 0));

//        System.out.println(levelOrderTraversal(root));
        System.out.println(getDiffHeightByRecursion(root));
    }

    private static boolean getDiffHeightByRecursion(TreeNode root) {

        if(root == null) {
            return true;
        }

        int left = getHeightByRecursion(root.left);
        int right = getHeightByRecursion(root.right);

        if(Math.abs(left - right) > 1) {
            return false;
        }

        boolean leftB = getDiffHeightByRecursion(root.left);
        boolean rightB = getDiffHeightByRecursion(root.right);

        if(leftB && rightB) {
            return true;
        }

        return false;

    }


    private static boolean levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) return true; //edge condition
        que.add(root);
        while (!que.isEmpty()) {
            int levelNum = que.size();
            for (int i = 0; i < levelNum; i++) {
                int left = getHeightByRecursion(que.peek().left);
                int right = getHeightByRecursion(que.peek().right);

                if (Math.abs(left - right) > 1) {
                    return false;
                }

                if (que.peek().left != null) {
                    que.add(que.peek().left);
                }

                if (que.peek().right != null) {
                    que.add(que.peek().right);
                }
                que.poll();
            }
        }
        return true;
    }


    private static int getHeightByRecursion(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeightByRecursion(root.left), getHeightByRecursion(root.right));
    }
}
