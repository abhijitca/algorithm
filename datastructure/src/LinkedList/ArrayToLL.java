package LinkedList;

public class ArrayToLL {

    public static void main(String args[]) {
        int[] n = new int[4];
        n = new int[]{1, 2, 3, 4};
        arrayToLL(n);
    }

    public static ListNode arrayToLL(int[] n) {
        ListNode dummy = new ListNode(-1);
        ListNode temp;
        temp = dummy;
        for (int i = 0; i < n.length; i++) {
            temp.next = new ListNode(n[i]);
            temp = temp.next;
        }
        return dummy.next;
    }
}
