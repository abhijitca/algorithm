package Blind75;

public class LongestPallindromicString {
    public static void main(String args[]) {
        String s = "amlpggpl";
        char[] c = s.toCharArray();
        System.out.println(findPallindrome(s));
    }

    private static String findPallindrome(String s) {
        // odd length
        int r = 0;
        int l = 0;
        int max = Integer.MIN_VALUE;
        String fin = "";
        for (int i = 0; i < s.length(); i++) {

            l = i;
            r = i;
            while (l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
                if (max <= (r - l + 1)) {
                    max = r - l + 1;
                    fin = s.substring(l, r+1);
                }
                r = r + 1;
                l = l - 1;
            }

            l = i;
            r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
                if (max <= (r - l + 1)) {
                    max = r - l + 1;
                    fin = s.substring(l, r+1);
                }
                r = r + 1;
                l = l - 1;
            }

        }


        return fin;

    }


}
