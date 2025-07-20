package searching;

import java.util.ArrayList;
import java.util.List;

public class FirstAndLast34 {
    public static int[] main(String[] args) {
        int[] n = {};
        int s = 30;
        int low = 0;
        int high = n.length - 1;
        int mid = (low + high) / 2;
        List<Integer> list = new ArrayList();
        binarySearchC(n, low, high, mid, s, list);
        int[] arr = new int[list.size()];
        for(int i=0;i< list.size();i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    private static int binarySearchC(int[] n, int low, int high, int mid, int search, List<Integer> list) {
        if (high < low) {
            list.add(-1);
            list.add(-1);
            return low;
        }
        if (n[mid] == search) {
            findRange(n, mid, search, list);
            return mid;
        } else if (search < n[mid]) {
            high = mid - 1;
            mid = (low + high) / 2;
            return binarySearchC(n, low, high, mid, search, list);
        } else {
            low = mid + 1;
            mid = (low + high) / 2;
            return binarySearchC(n, low, high, mid, search, list);
        }
    }

    private static void findRange(int[] n, int mid, int search, List<Integer> list) {
        int pos = mid;
        while(mid > -1 && n[mid] == search) {
            mid--;
        }
        list.add(mid+1);

        while(pos < n.length && n[pos] == search) {
            pos++;
        }
        list.add(pos -1);
    }
}
