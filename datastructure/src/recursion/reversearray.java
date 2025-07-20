package recursion;

import java.util.Arrays;

public class reversearray {

    public static void main(String args[]) {
        int[] n = {1, 2, 3, 4, 5, 6};
        int[] j = Arrays.stream(reverseArray(n, 0, n.length - 1)).toArray();
        System.out.println(j);
    }

    private static int[] reverseArray(int[] n, int l, int r) {
        if (l >= r) {
            return n;
        }
        int temp = n[l];
        n[l] = n[r];
        n[r] = temp;
        return reverseArray(n, l+1, r-1);
    }
}
