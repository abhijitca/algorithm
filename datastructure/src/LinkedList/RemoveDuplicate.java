package LinkedList;

public class RemoveDuplicate {
    public static void main(String args[]) {
        ListNode listNode5 = new ListNode(3);
        ListNode listNode4 = new ListNode(1, listNode5);
        ListNode listNode3 = new ListNode(1, listNode4);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        deleteDuplicates(listNode1);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        int k=1;
        ListNode ini = head;
        while(head != null && head.next != null) {
            if(head.val == k && head.next.val == k+1) {
                head = head.next;
                k++;
            } else {
                if(head.next!=null) {
                    head.next = head.next.next;
                }
            }
        }
        return ini;
    }

//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode res = head;
//
//        while (head != null && head.next != null) {
//            if (head.val == head.next.val) {
//                head.next = head.next.next;
//            } else {
//                head = head.next;
//            }
//        }
//
//        return res;
//    }


}
