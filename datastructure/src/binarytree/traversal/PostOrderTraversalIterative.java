package binarytree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIterative {

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

//        inOrderTraversal(root);
        postOrderTraversal(root).forEach(number -> System.out.print(number + " "));

    }

    private static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> rootSt = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                rootSt.add(node);
                node = node.left;
            } else {
                if(rootSt.isEmpty())
                    break;
                if(rootSt.peek().right == null)
                    rootSt.pop();
                list.add(node.val);
                node = rootSt.peek().right.right;
            }

        }
        return list;
    }
}
