package LinkedList.doublyll;

import java.util.HashMap;

class LRUCache {

    HashMap<Integer, DoublyLL> hmCount = new HashMap<>();
    //create a dummy head
    DoublyLL head = new DoublyLL(-1, -1);
    //create a dummy tail
    DoublyLL tail = new DoublyLL(-1, -1);

    DoublyLL ptr;

    int maxSize = 0;

    public LRUCache(int capacity) {
        maxSize = capacity;
        head.next = tail;
        tail.previous = head;
        ptr = head;
    }

    public int get(int key) {
        int fin = -1;
        DoublyLL doublyLL = hmCount.get(key);
        if (hmCount.get(key) != null) {
            fin = hmCount.get(key).n;
            //delete the node
            doublyLL.next.previous = doublyLL.previous;
            doublyLL.previous.next = doublyLL.next;

            //add it at the end.
            doublyLL.next = tail;
            doublyLL.previous = tail.previous;
            tail.previous.next = doublyLL;
            tail.previous = doublyLL;
        }
        return fin;
    }

    public void put(int key, int value) {
        DoublyLL doublyLL;
        if (maxSize > 0) {
            //add it in the tail
            doublyLL = new DoublyLL(value, key);
            ptr.next = doublyLL;
            doublyLL.previous = ptr;
            doublyLL.next = tail;
            tail.previous = doublyLL;
            ptr = doublyLL;

            //decrease the size
            maxSize = maxSize - 1;
            // store it hashmap
            hmCount.put(key, doublyLL);
        } else if (hmCount.containsKey(key)) {
            DoublyLL doublyLL1 = hmCount.get(key);
            doublyLL1.n = value;

            //delete the node
            doublyLL1.next.previous = doublyLL1.previous;
            doublyLL1.previous.next = doublyLL1.next;

            //add it at the end.
            doublyLL1.next = tail;
            doublyLL1.previous = tail.previous;
            tail.previous.next = doublyLL1;
            tail.previous = doublyLL1;

        } else if (head.next.next != null) {
            //delete from head
            doublyLL = head.next;
            hmCount.remove(doublyLL.key);

            //if only one element
            if(doublyLL.next.next == null) {
                ptr = head;
            } else {
                ptr = tail.previous;

            }


            //delete the node
            doublyLL.next.previous = doublyLL.previous;
            doublyLL.previous.next = doublyLL.next;

            maxSize = maxSize + 1;

            //add it in the tail
            doublyLL = new DoublyLL(value, key);
            ptr.next = doublyLL;
            doublyLL.previous = ptr;
            doublyLL.next = tail;
            tail.previous = doublyLL;
            ptr = doublyLL;

            //decrease the size
            maxSize = maxSize - 1;
            // store it hashmap
            hmCount.put(key, doublyLL);
        }
    }

    public static void main(String args[]) {
        LRUCache lRUCache = new LRUCache(1);
        System.out.println(lRUCache.get(6));    // return -1 (not found)
        System.out.println(lRUCache.get(8));    // return 3
        lRUCache.put(12, 1);
        System.out.println(lRUCache.get(2));
        lRUCache.put(15, 11);
        lRUCache.put(5, 2);
        lRUCache.put(1, 15);
        lRUCache.put(4, 2);
        System.out.println(lRUCache.get(4));
        lRUCache.put(15, 15);
    }

    public class DoublyLL {
        int n;
        int key;
        DoublyLL next;
        DoublyLL previous;

        DoublyLL(int n, int key) {
            this.n = n;
            this.key = key;
        }

        DoublyLL(int n, int key, DoublyLL next, DoublyLL previous) {
            this.n = n;
            this.key = key;
            this.next = next;
            this.previous = previous;
        }
    }
}
