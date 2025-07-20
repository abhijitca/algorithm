package binarytree.same;

public class CheckSameBinaryTree {
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
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);


        TreeNode root1 = new TreeNode(1);
//        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(3);


        System.out.println(isSameTree(root, root1));
    }
    public static boolean isSame = true;

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        isSameTree1(p, q);
        return isSame;
    }

    public static void isSameTree1(TreeNode p, TreeNode q) {

        if(p==null && q!=null) {
            isSame = false;
            return;
        }

        if(q==null && p!=null) {
            isSame = false;
            return;
        }

        if(p==null && q == null) {
            return;
        }
        if(p.val != q.val) {
            isSame = false;
            return;
        }

        isSameTree1(p.left, q.left);
        isSameTree1(p.right, q.right);
    }
}
