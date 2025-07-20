package Blind75;

import java.util.HashMap;

public class LongestSubstringwithoutrepeatedchar {
    public static void main(String args[]) {
        String s = "aab";
        System.out.println(findSubString(s));
    }

    public static int findSubString(String s) {
        int ptr1 = 0;
        int ptr2 = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;
        while (ptr2 < s.length()) {
            if(hm.containsKey(s.charAt(ptr2)) && hm.get(s.charAt(ptr2)) >= ptr1) {
                ptr1 = hm.get(s.charAt(ptr2)) + 1;
            }
            hm.put(s.charAt(ptr2), ptr2);
            max = Math.max(max, ptr2 - ptr1 + 1);
            ptr2++;
        }
        return max;
    }
}
