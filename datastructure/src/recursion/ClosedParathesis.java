package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosedParathesis {
    public static void main(String args[]) {
        List<String> list = new ArrayList<>();

        List n= generateParenthesis1(4, 4, "", list);
        System.out.println(n);
    }

    private static List<String> generateParenthesis1(int open, int close, String s, List<String> list) {
        if (open == 0 && close == 0) {
            list.add(s);
            return list;
        }
        if (open != 0) {
            generateParenthesis1(open - 1, close, s+"(", list);
        }
        if (close > open) {
            generateParenthesis1(open, close - 1, s+")", list);
        }
        return list;
    }

    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }

        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }


}
