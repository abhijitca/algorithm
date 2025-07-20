package LinkedList;

import java.util.List;

public class deletionAtK {
    public static void main(String args[]) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        //deletetionatk(listNode1, 5);
        addatk(listNode1, 5);
    }

    public static ListNode deletetionatk(ListNode head, int k) {
        if (k == 0) return head;

        if (k == 1) return head.next;

        ListNode prev = head;
        ListNode curr = head.next;
        int c = 2;
        while (curr != null) {
            if (c == k) {
                prev.next = curr.next;
                break;
            }
            c++;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static ListNode addatk(ListNode head, int k) {
        if (k == 1) {
            ListNode temp = new ListNode(10, head);
            return temp;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        int c = 2;
        while (curr != null) {
            if(c == k) {
                ListNode list = new ListNode(10, curr);
                prev.next = list;
                break;
            }
            c++;
            prev = curr;
            curr = curr.next;

        }
        return head;
    }
}
