package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintAllSubsequence {
    public static void main(String args[]) {
        int[] n = {3, 1, 2};
        Stack<Integer> arr = new Stack<Integer>();
        allSubsequence(n, arr, 0);
    }

    private static List<Integer> allSubsequence(int[] n, Stack<Integer> arr, int index) {
        if (index >= n.length) {
            arr.stream().forEach(e -> System.out.print(e));
            System.out.println();
            return arr;
        }
        arr.add(n[index]);
        allSubsequence(n, arr, index + 1);
        arr.pop();
        allSubsequence(n, arr, index + 1);
        return arr;
    }

}
