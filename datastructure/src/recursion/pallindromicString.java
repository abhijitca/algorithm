package recursion;

public class pallindromicString {
    public static void main(String args[]) {
        String s = "abcbcba";
        System.out.println(checkPallindrome(s.toCharArray(), 0));
    }

    private static boolean checkPallindrome(char[] s, int i) {

        if (i >= (s.length / 2)) {
            return true;
        }

        if (s[i] != s[s.length - i - 1]) {
            return false;
        }

        return checkPallindrome(s, i + 1);
    }

}
