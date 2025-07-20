package binarytree.construct;

import java.util.HashMap;
import java.util.HashSet;

public class PreOrderInOderTree {

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
        int[] p = {3,9,20,15,7};
        int[] i = {9,3,15,20,7};
        TreeNode n = buildTree(p, i);
        System.out.println(n);
    }

    static HashMap<Integer, Integer> hmPosition = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            hmPosition.put(inorder[i], i);
        }

        TreeNode root = createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hmPosition);

        return root;
    }

    private static TreeNode createTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> hmPosition) {

        if(preStart>preEnd || inStart > inEnd) return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int mid = hmPosition.get(node.val);
        int len = mid - inStart;

        node.left = createTree(preorder, preStart + 1, preStart + len, inorder, inStart, mid - 1, hmPosition);

        node.right = createTree(preorder, preStart + len + 1, preEnd, inorder, mid + 1, inEnd, hmPosition);

        return node;
    }


}
