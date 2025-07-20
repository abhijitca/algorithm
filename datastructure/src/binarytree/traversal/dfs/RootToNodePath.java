package binarytree.traversal.dfs;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
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

        List<TreeNode> list = new ArrayList<>();
        int k = 7;
        list.add(root);
        rootToNodePath(root.left, k, list);
        list.forEach(l -> System.out.println(l.val));
    }

    private static boolean rootToNodePath(TreeNode root, int k, List<TreeNode> list) {

        if (root == null) return false;
        if (root == null) return false;
        list.add(root);

        if (root.val == k) return true;


        boolean left = rootToNodePath(root.left, k, list);
        if(!left) {
            list.remove(root);
        } else {
            return true;
        }
        list.add(root);
        boolean right = rootToNodePath(root.right, k, list);
        if(!right) {
            list.remove(root);
        } else {
            return true;
        }
        return false;
    }
}
