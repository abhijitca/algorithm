package binarytree.traversal;

import java.util.*;

public class ZigZagTraversal {

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
        root.right.right = new TreeNode(5);
//        root.left.right = new TreeNode(6);
//        root.right.left = new TreeNode(7);
        zigzagLevelOrder(root).forEach(list -> System.out.println(list));
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Stack<Integer> st = new Stack<>();
            Queue<Integer> queue1 = new LinkedList<>();
            for (int i = 0; i < size; i++) {

                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                if (count % 2 == 1) {
                    st.add(queue.poll().val);
                } else {
                    queue1.add(queue.poll().val);
                }
            }

            loadIntoArray(list, st, queue1);
            count++;
        }
        return list;
    }

    private static void loadIntoArray(List<List<Integer>> list, Stack<Integer> st, Queue<Integer> queue1) {
        List list1 = new ArrayList();
        if (st.size() > 0) {
            while(!st.isEmpty()) {
                list1.add(st.pop());
            }
        } else {
            while(!queue1.isEmpty()) {
                list1.add(queue1.poll());
            }
        }
        list.add(list1);
    }

}
