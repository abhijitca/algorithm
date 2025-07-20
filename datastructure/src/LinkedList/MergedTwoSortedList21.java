package LinkedList;

public class MergedTwoSortedList21 {
    public static void main(String args[]) {
//        ListNode listNode5 = new ListNode(8);
//        ListNode listNode4 = new ListNode(6, listNode5);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

//        ListNode listNode55 = new ListNode(9);
//        ListNode listNode44 = new ListNode(7, listNode55);
        ListNode listNode33 = new ListNode(4);
        ListNode listNode22 = new ListNode(2, listNode33);
        ListNode listNode11 = new ListNode(1, listNode22);
        mergeTwoLists(listNode1, listNode11);
    }

//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1 == null || list2 == null) {
//            return list1 == null ? list2 : list1;
//        }
//        if (list1.val <= list2.val) {
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = mergeTwoLists(list2.next, list2);
//            return list2;
//        }
//    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else if(list2.val < list1.val) {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if (list1 == null)
            temp.next = list2;
        else if (list2 == null){
            temp.next = list1;
        }
        return dummy.next;
    }
}
