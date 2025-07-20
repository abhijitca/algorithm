package string;

public class MinAddToMakeValid {
    public static void main(String args[]) {
        String s = "(()))()(";
        String s1 = "))()()))(";
        System.out.println(minAddToMakeValid(s1));
    }

    public static int minAddToMakeValid(String s) {
        int countOpen = 0;
        int countClose = 0;
        int fin = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                countOpen++;
            } else {
                countClose++;
            }
            if (countClose > countOpen) {
                fin++;
                countOpen++;
            }
        }
        while (countClose < countOpen) {
            fin++;
            countClose++;
        }
        return fin;
    }
}
