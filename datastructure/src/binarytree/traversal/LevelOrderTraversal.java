package binarytree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTraversal {
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

        levelOrderTraversal(root);
    }

    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) return list; //edge condition
        que.add(root);

        while (!que.isEmpty()) {
            int levelNum = que.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (que.peek().left != null) {
                    que.add(que.peek().left);
                }
                if (que.peek().right != null) {
                    que.add(que.peek().right);
                }
                subList.add(que.poll().val);
            }
            list.add(subList);
        }
        return list;
    }

}
