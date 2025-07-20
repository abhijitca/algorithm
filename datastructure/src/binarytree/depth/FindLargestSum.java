package binarytree.depth;

public class FindLargestSum {

    private static int max;

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
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(-1);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//        root.right.right.left = new TreeNode(7);
//        root.right.right.left.right = new TreeNode(6);
        System.out.println(getMaxSum(root));
    }

    private static int longestNo = Integer.MIN_VALUE;

    private static int getMaxSum(TreeNode root) {
        findWeight(root);
        return longestNo;
    }

    private static int findWeight(TreeNode root) {
        if (root == null || root == null) return 0;

        int lHeight = findWeight(root.left);

        int rHeight = findWeight(root.right);

        longestNo = Math.max(lHeight + rHeight + root.val, longestNo);

        return Math.max(lHeight, rHeight) + root.val < 0 ? 0 : Math.max(lHeight, rHeight) + root.val ;
    }

}
