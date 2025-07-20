package LinkedList;

public class MergeTwoSortedListRevision {
    public static void main(String args[]) {
        ListNode listNode4 = new ListNode(5);
        ListNode listNode3 = new ListNode(4, listNode4);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

//        ListNode listNode55 = new ListNode(9);
//        ListNode listNode44 = new ListNode(7, listNode55);
        ListNode listNode33 = new ListNode(4);
        ListNode listNode22 = new ListNode(2, listNode33);
        ListNode listNode11 = new ListNode(1, listNode22);
        mergeTwoLists(listNode1, listNode11);
    }

    public static void mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finNode = new ListNode(-1);
        ListNode finalR = finNode;
        ListNode h1 = list1;
        ListNode h2 = list2;

        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                finNode.next = h1;
                h1 = h1.next;
            } else {
                finNode.next = h2;
                h2 = h2.next;
            }
            finNode = finNode.next;
        }
        if(h1!=null) {
            finNode.next = h1;
        } else {
            finNode.next = h2;
        }

    }
}
