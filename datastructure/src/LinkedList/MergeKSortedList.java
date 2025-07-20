package LinkedList;

import java.util.HashMap;
import java.util.List;

public class MergeKSortedList {
    public static void main(String args[]) {
        ListNode[] lists = new ListNode[3];
//        ListNode listNode5 = new ListNode(8);
//        ListNode listNode4 = new ListNode(6, listNode5);
        ListNode listNode3 = new ListNode(8);
        ListNode listNode2 = new ListNode(3, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

//        ListNode listNode55 = new ListNode(9);
//        ListNode listNode44 = new ListNode(7, listNode55);
        ListNode listNode33 = new ListNode(4);
        ListNode listNode22 = new ListNode(2, listNode33);
        ListNode listNode11 = new ListNode(1, listNode22);

        ListNode listNode333 = new ListNode(12);
        ListNode listNode222 = new ListNode(11, listNode333);
        ListNode listNode111 = new ListNode(-10, listNode222);


        lists[0] = listNode1;
        lists[1] = listNode11;
        lists[2] = listNode111;

        mergeKLists(lists);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ptr = new ListNode(-1);
        ListNode head = ptr;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            ListNode h1 = list;
            while (h1 != null) {
                if(max < h1.val) {
                    max = h1.val;
                }
                if(min > h1.val) {
                    min = h1.val;
                }
                if (hm.get(h1.val) != null) {
                    int c = hm.get(h1.val);
                    hm.put(h1.val, c + 1);
                } else
                    hm.put(h1.val, 1);
                h1 = h1.next;
            }
        }

        for (int i = min; i <= max; i++) {
            if (hm.get(i) != null) {
                int c = hm.get(i);
                while(c!=0) {
                    ListNode n =new ListNode(i);
                    ptr.next = n;
                    ptr = ptr.next;
                    c--;
                }
            }
        }
        return head.next;
    }
}
