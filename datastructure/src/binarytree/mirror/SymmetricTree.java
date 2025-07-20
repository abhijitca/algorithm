package binarytree.mirror;

public class SymmetricTree {
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
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);

        checkSymmetric(root.left, root.right);
        System.out.println(isSym);
    }
    static boolean isSym = true;
    private static void checkSymmetric(TreeNode lRoot, TreeNode rRoot) {
        if(lRoot == null && rRoot != null) {
            isSym = false;
            return;
        }

        if(lRoot != null && rRoot == null) {
            isSym = false;
            return;
        }

        if(lRoot == null && rRoot == null) {
            return;
        }

        if(lRoot.val != rRoot.val) {
            isSym = false;
            return;
        }
        checkSymmetric(lRoot.right, rRoot.left);
        checkSymmetric(lRoot.left, rRoot.right);
    }
}
