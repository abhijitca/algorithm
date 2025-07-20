package sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String args[]) {
        int[] n = {-16, 10, 8, 4, 2, 5, 18, 12, 15, 65, 3, 68};

        int low = 0;
        int high = n.length - 1;
        int pivot = n[0];

        quickSort(n, high, low);
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i]);
        }
    }

    private static void quickSort(int[] n, int high, int low) {
        //find pivot
        if (high <= low) {
            return;
        }

        //set the pivot to the correct position

        int mirror = findMirror(n, high, low);

        // do the same for right part

        quickSort(n, high, mirror + 1);


        //do the same for left part
        quickSort(n, mirror - 1, low);
    }

    private static int findMirror(int[] n, int high, int low) {
        int i = low + 1;
        int j = high;
        int pivot = n[low];
        while (i < j) {
            while (n[i] <= pivot) {
                i++;
            }

            while (n[j] > pivot) {
                j--;
            }
            if (i < j)
                swap(n, i, j);
        }
        swap(n, low, j);
        return j;
    }

    private static void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}
