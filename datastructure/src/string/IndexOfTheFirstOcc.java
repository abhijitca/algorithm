package string;

import java.util.*;

public class IndexOfTheFirstOcc {
    public static void main(String args[]) {
        System.out.println(strStr("pgiveopinjfndihcklgiuebgfnfgolegnbgk", "giue"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        char c1 = needle.charAt(0);
        char c2 = needle.charAt(needle.length() - 1);

        Map<String, Integer> hs = new TreeMap<>();

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (c1 == haystack.charAt(i) && c2 == haystack.charAt(i + needle.length() - 1)) {
                String substring = haystack.substring(i, i + needle.length());
                if (!hs.containsKey(substring)) {
                    hs.put(substring, i);
                }
            }
        }
        return hs.containsKey(needle) ? hs.get(needle) : -1;
    }
}
