package searching;

public class FindNumberInRotatedArray33 {
    public static void main(String args[]) {
        int[] n = {50,50,60,60,70,10,10,20,30,40};
        int s = 10;
        int low = 0;
        int high = n.length - 1;
        System.out.println(binarySearchC(n, low, high, s));
    }

    private static int binarySearchC(int[] n, int low, int high, int target) {
        //base condition
        if (high < low) {
            return -1;
        }

        int mid = (high + low) /2;

        //check at the mid
        if(n[mid] == target) {
            return mid;
        }

        //check if left is sorted
        if(n[low] <= n[mid]) {
            if(n[low] <= target && target <= n[mid]) {
                return binarySearchC(n, low, mid -1, target);
            } else {
                return binarySearchC(n, mid + 1, high, target);
            }
        } else {
            if(n[mid] <= target && target <= n[high]) { // sorted list
                return binarySearchC(n, mid + 1, high, target);
            } else {
                return binarySearchC(n, low, mid - 1, target);
            }
        }
    }
}
