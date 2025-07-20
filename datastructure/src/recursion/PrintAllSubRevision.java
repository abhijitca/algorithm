package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintAllSubRevision {

    public static void main(String args[]) {
        int[] n = {3,1,2};
        subsets(n);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int ptr = 0;
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> lists1 = findSubset(nums, stack, ptr, lists);
        return lists1;
    }

    private static List<List<Integer>> findSubset(int[] nums, Stack<Integer> stack, int ptr, List<List<Integer>> lists) {
        if(ptr == nums.length) {
            Stack<Integer> stack1 = new Stack<>();
            stack1.addAll(stack);
            lists.add(stack1);
            return lists;
        }

        stack.add(nums[ptr]);
        findSubset(nums, stack, ptr+1, lists);
        stack.pop();
        findSubset(nums, stack, ptr+1, lists);
        return lists;
    }
}
