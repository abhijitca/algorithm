package LinkedList.doublyll;

public class Insertion {
    public static void main(String args[]) {
        DoublyLL head = new DoublyLL(-1);
        DoublyLL tail = new DoublyLL(-1);
        //insert 1
        DoublyLL doublyLL1 = new DoublyLL(1);
        head.next = doublyLL1;
        doublyLL1.previous = head;
        doublyLL1.next = tail;
        tail.previous = doublyLL1;
        //insert 2
        DoublyLL doublyLL2 = new DoublyLL(2);
        doublyLL1.next = doublyLL2;
        doublyLL2.previous = doublyLL1;
        doublyLL2.next = tail;
        tail.previous = doublyLL2;

        //insert 3
        DoublyLL doublyLL3 = new DoublyLL(3);
        doublyLL2.next = doublyLL3;
        doublyLL3.previous = doublyLL2;
        doublyLL3.next = tail;
        tail.previous = doublyLL3;


        // print all from head
        while (head.next.n != -1) {
            System.out.println(head.next.n);
            head = head.next;
        }
        // print all from tail
        while (tail.previous.n != -1) {
            System.out.println(tail.previous.n);
            tail = tail.previous;
        }

    }

    public static class DoublyLL {
        int n;
        DoublyLL next;
        DoublyLL previous;

        DoublyLL(int n) {
            this.n = n;
        }

        DoublyLL(int n, DoublyLL next, DoublyLL previous) {
            this.n = n;
            this.next = next;
            this.previous = previous;
        }
    }
}
