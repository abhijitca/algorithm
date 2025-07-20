package binarytree.traversal;

import javafx.util.Pair;
import org.w3c.dom.Node;

import java.util.*;

public class VerticalOrderTraversal {
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

    static HashMap<Integer, PriorityQueue<NodeDetail>> hm = new HashMap<>();

    public static void main(String args[]) {
        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
//        root.left.left = new TreeNode(4);
//        root.right.right = new TreeNode(6);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(2);

        verticalOrderTraversal1(root, 0);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1;
        for (int i = -30; i < 30; i++) {
            if(hm.containsKey(i)) {
                list1 = new ArrayList<>();
                PriorityQueue<NodeDetail> p = hm.get(i);
                while (!p.isEmpty()) {
                    list1.add(p.poll().root.val);
                }
                list.add(list1);
            }
        }
        System.out.println(list);
    }

    public static class NodeDetail {
        TreeNode root;
        int verticalLevel; //-2, -1 , 0, 1, 2
        int horizontalLevel; // 0,1,2,3

        public NodeDetail(TreeNode root, int verticalLevel, int horizontalLevel) {
            this.root = root;
            this.verticalLevel = verticalLevel;
            this.horizontalLevel = horizontalLevel;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeDetail that = (NodeDetail) o;
            return verticalLevel == that.verticalLevel && horizontalLevel == that.horizontalLevel;
        }

        @Override
        public int hashCode() {
            return Objects.hash(verticalLevel, horizontalLevel);
        }
    }

    public static class NodeDetailComparator implements Comparator<NodeDetail> {

        @Override
        public int compare(NodeDetail obj1, NodeDetail obj2) {
            // 1. Compare by verticalLevel
            int verticalComparison = Integer.compare(obj1.verticalLevel, obj2.verticalLevel);
            if (verticalComparison != 0) {
                return verticalComparison;
            }

            // 2. If verticalLevels are equal, compare by horizontalLevel
            int horizontalComparison = Integer.compare(obj1.horizontalLevel, obj2.horizontalLevel);
            if (horizontalComparison != 0) {
                return horizontalComparison;
            }

            // 3. If both verticalLevel and horizontalLevel are equal, compare by root.val
            // This is where the priority for the smaller root.val comes in.
            return Integer.compare(obj1.root.val, obj2.root.val);
        }
    }

    private static void verticalOrderTraversal1(TreeNode root, int pos) {
        Queue<NodeDetail> queue = new LinkedList();
        queue.add(new NodeDetail(root, 0, 0));
        int horizontalLevel = 1;
        int verticalLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                if (queue.peek().root.left != null)
                    queue.add(new NodeDetail(queue.peek().root.left, queue.peek().verticalLevel - 1, horizontalLevel));
                if (queue.peek().root.right != null)
                    queue.add(new NodeDetail(queue.peek().root.right, queue.peek().verticalLevel + 1, horizontalLevel));

                NodeDetail nodeDetail = queue.poll();

                if (hm.containsKey(nodeDetail.verticalLevel)) {
                    PriorityQueue pq = hm.get(nodeDetail.verticalLevel);
                    pq.add(nodeDetail);
                    hm.put(nodeDetail.verticalLevel, pq);
                } else {
                    PriorityQueue pq = new PriorityQueue<>(new NodeDetailComparator());
                    pq.add(nodeDetail);
                    hm.put(nodeDetail.verticalLevel, pq);
                }
            }
            horizontalLevel++;
        }
    }

}
