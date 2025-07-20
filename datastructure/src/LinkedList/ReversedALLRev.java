package LinkedList;

public class ReversedALLRev {
    public static void main(String args[]) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        reverseLL(listNode1);
    }

    public static ListNode reverseLL(ListNode node) {
        if(node == null) {
            return node;
        }
        ListNode prev = null;
        ListNode next = node.next;

        while (node != null) {
            node.next = prev;
            prev = node;
            node = next;
            if(next!=null)
            next = next.next;
        }
    return prev;
    }
}
