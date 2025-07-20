package LinkedList;

public class RverseLinkedList206 {
    public static void main(String args[]) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        deleteDuplicates(listNode1);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            //update to next
            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;
        return head;
    }
}
