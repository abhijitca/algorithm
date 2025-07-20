package searching;

public class BinarySearch {

    public static void main(String args[]) {
        int[] n = {10,20,30,40,50};
        int s = 41;
        int low = 0;
        int high = n.length - 1;
        int mid = (low + high) / 2;
        System.out.println(binarySearchC(n, low, high, mid, s));
    }

    private static int binarySearchC(int[] n, int low, int high, int mid, int search) {
        if (high < low) {
            return low;
        }
        if (n[mid] == search) {
            return mid;
        } else if (search < n[mid]) {
            high = mid - 1;
            mid = (low + high) / 2;
            return binarySearchC(n, low, high, mid, search);
        } else {
            low = mid + 1;
            mid = (low + high) / 2;
            return binarySearchC(n, low, high, mid, search);
        }
    }
}
