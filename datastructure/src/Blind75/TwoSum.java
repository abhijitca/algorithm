package Blind75;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

    public static void main(String args[]) {
        int[] n = {3,2,4};
        int s = 6;
        int[] sum = twoSum(n, s);
        System.out.println(sum[0]);
        System.out.println(sum[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] fin = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(target - nums[i])) {
                hm.put(target - nums[i], i);
            }
            if(hm.containsKey(nums[i]) && hm.get(nums[i])!=i) {
                fin[0] = hm.get(nums[i]);
                fin[1] = i;
                break;
            }
        }

        return fin;
    }
}
