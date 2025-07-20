package binarytree.traversal;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class PreOrderInOrderPostOrder {
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

        calculateAllTraversal(root);
    }

    private static List<Integer> calculateAllTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        TreeNode head = root;

        Stack<Pair<TreeNode, Integer>> st = new Stack<>();
        if (root == null) return preOrder;

        Pair<TreeNode, Integer> parentpair = new Pair<>(root, 1);
        st.push(parentpair);

        while (!st.isEmpty()) {
            Pair<TreeNode, Integer> pair = st.pop();
            Pair<TreeNode, Integer> hmnew = null;
            if (pair.getValue() == 1) {
                preOrder.add(pair.getKey().val);
                //++
                Pair p = new Pair(pair.getKey(), pair.getValue() + 1);
                st.push(p);
                //add left
                if (pair.getKey().left != null) {
                    hmnew = new Pair<>(pair.getKey().left, 1);
                    st.push(hmnew);
                }
            } else if (pair.getValue() == 2) {
                inOrder.add(pair.getKey().val);
                //++
                Pair p = new Pair(pair.getKey(), pair.getValue() + 1);
                st.push(p);
                //add right
                if (pair.getKey().right != null) {
                    hmnew = new Pair<>(pair.getKey().right, 1);
                    st.push(hmnew);
                }
            } else {
                postOrder.add(pair.getKey().val);
            }
        }

//        inOrder
//        if(Integer == 1)
//          ++
//          left
//          if(Integer == 2) {
        //++
//          right
//          }
//        if(Integer == 3) {
//          }

        return postOrder;
    }
}
