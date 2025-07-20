package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String args[]) {
        int[] n = {50, 9, 10, 7, 3, 4, 1};
        int j[] = mSort(n, 0, n.length - 1);
        System.out.println(j);
    }

    private static int[] mSort(int[] n, int l, int r) {
        if (l >= r) {
            System.out.println(n[r]);
            return n;
        }

        int mid = (l + r) / 2;

        mSort(n, l, mid);

        mSort(n, mid + 1, r);

        mergeArr(n, l, mid, r);

        return n;
    }

    private static void mergeArr(int[] n, int l, int mid, int r) {
        List<Integer> list = new ArrayList<>();
        int p1 = l;
        int l2 = mid;

        int p2 = mid + 1;
        int l4 = r;

        while (p1 <= l2 && p2 <= l4) {
            if (n[p1] <= n[p2]) {
                list.add(n[p1]);
                p1++;
            } else {
                list.add(n[p2]);
                p2++;
            }
        }
        while (p1 <= l2) {
            list.add(n[p1]);
            p1++;
        }

        while (p2 <= l4) {
            list.add(n[p2]);
            p2++;
        }
        int k=0;
        for (int i = l; i <= r; i++) {
            n[i] = list.get(k);
            k++;
        }
    }
}
