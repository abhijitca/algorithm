package string;

public class RTERecursive {
    public static void main(String args[]) {
        int n = 4;
        System.out.println(calCRTE("1123334555"));
    }

    private static String calCRTE(String s) {
//        if (n == 1) return "1";
//        String s = calCRTE(n - 1);
        String fin = "";
        int count = 1;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i + 1)) {
                count++;
                continue;
            } else {
                c = s.charAt(i + 1);
            }
            fin += count + (s.charAt(i) + "");
            count = 1;
        }
        return fin;
    }
}
