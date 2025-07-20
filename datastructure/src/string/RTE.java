package string;

import java.util.HashMap;

public class RTE {
    static HashMap<Integer, String> hm = new HashMap();

    public static void main(String args[]) {
        hm.put(1, "1");
        for (int i = 2; i <= 30; i++) {
            hm.put(i, calcRTE(i));
        }
    }

    private static String calcRTE(int no) {
        String s = hm.get(no - 1);
        StringBuilder fin = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            int count = 1;
            int j = i + 1;
            for (; j < s.length(); ) {
                char c1 = s.charAt(j);
                if (c == c1) {
                    count++;
                    j++;
                } else
                    break;
            }
            i = j;
            fin.append(count).append(c+"");
//            fin += count + (c+"");
        }
        return fin.toString();
    }
}
