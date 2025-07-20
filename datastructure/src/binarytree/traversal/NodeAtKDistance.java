package binarytree.traversal;

import java.util.*;

public class NodeAtKDistance {
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
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        List<TreeNode> list = new ArrayList<>();
        int k = 2;
        distanceK(root, root.left, 2);
    }

    static HashMap<TreeNode, TreeNode> hmParent = new HashMap<>();
    static Set<TreeNode> visitedNode = new HashSet<>();
    static List<Integer> list = new ArrayList<>();
    static int count = 0;

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // level order traversal to capture parent of all the node
        // Child, parent
        Queue<TreeNode> que = new LinkedList();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                if (que.peek().left != null) {
                    hmParent.put(que.peek().left, que.peek());
                    que.add(que.peek().left);
                }
                if (que.peek().right != null) {
                    hmParent.put(que.peek().right, que.peek());
                    que.add(que.peek().right);
                }
                que.poll();
            }
        }

        getAllNode(target, count, k);
        return list;
    }

    private static void getAllNode(TreeNode target, int count, int k) {
        visitedNode.add(target);
        if(target == null) return;
        if (count == k) {
            list.add(target.val);
            return;
        }

        if (!visitedNode.contains(target.left)) {
            getAllNode(target.left, count + 1, k);
        }
        if (!visitedNode.contains(target.right)) {
            getAllNode(target.right, count + 1, k);
        }
        if (hmParent.containsKey(target) && !visitedNode.contains(hmParent.get(target))) {
            getAllNode(hmParent.containsKey(target) ? hmParent.get(target) : null, count + 1, k);
        }
    }
}
