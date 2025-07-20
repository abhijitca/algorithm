package TwoPointer;

public class LongestPallindromicSubString5 {
    public static void main(String args[]) {
        System.out.println(longestPalindrome("abaaba"));
    }

    public static String longestPalindrome(String s) {
        char ch[] = s.toCharArray();
        char p1 = 0;
        char p2 = 1;
        String fin = null;
        int mid = 0;
        String rfinal = "";
        boolean flag = true;
        boolean isodd = false;
        while (p2 != ch.length) {
            char first = ch[p1];
            char second = ch[p2];
            if (first == second) {
                int ip1 = p1;
                int ip2 = p2;
                fin = ch[ip2 - 1] + "";
                if(mid < ip2 -1) {
                    mid = ip2 - 1;
                    System.out.println(mid);
                }
                while (ip1 >= 0 && ip2 < ch.length && ch[ip1] == ch[ip2]) {
                    fin = fin + ch[ip1];
                    fin = ch[ip1] + fin;
                    if(fin.length() % 2 == 0) {
                        isodd = true;
                    } else {
                        isodd = false;
                    }
                    if(rfinal.length() < fin.length()) {
                        rfinal = fin;
                    }
                    ip1--;
                    ip2++;
                }
            }
            if (flag) {
                p2++;
                flag = false;
            } else {
                p1++;
                flag = true;
            }
        }
        char[] c = rfinal.toCharArray();
        String rfinl = "";
        for(int i=0;i<c.length;i++) {
            if(!(isodd && i == c.length/2))
                rfinl+=c[i];
        }
        return rfinl;
    }
}
