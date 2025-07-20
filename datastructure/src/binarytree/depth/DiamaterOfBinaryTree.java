package binarytree.depth;

public class DiamaterOfBinaryTree {
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
        root.right.right.left = new TreeNode(7);
        root.right.right.left.right = new TreeNode(6);
        System.out.println(getdiamter(root, 0));
    }

    private static int getdiamter(TreeNode root, int max) {
        if (root == null) {
            return max;
        }
        int maxLeftHeight = calculateheight(root.left);
        int maxRightHeight = calculateheight(root.right);
        max = Math.max(maxLeftHeight + maxRightHeight, max);
        return max;
    }

    private static int calculateheight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 1 + calculateheight(root.left);
        int right = 1 + calculateheight(root.right);
        return left > right ? left : right;
    }

}
