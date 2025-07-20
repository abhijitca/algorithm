package Blind75;

import java.util.HashSet;

public class LongestConsequenceSum {
    public static void main(String args[]) {
        int[] n = {-1,0};
        System.out.println(longestConsecutive(n));
    }

    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashSet<Integer> hm = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hm.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int val : hm) {
            if(hm.contains(val-1)) {
                continue;
            } else {
                int nu = val;
                int count = 0;
                while (hm.contains(nu + 1)) {
                    count = count + 1;
                    nu++;
                }
                if (max < count) {
                    max = count;
                }
            }

        }
        return max + 1;
    }
}
