package recursion;

public class Powerton {
    public static void main(String args[]) {
        findPower(0, 2, 0, 1);
    }

    private static double findPower(double val, double n, double h, double fin) {
        if (h <= n && n < 0) {
            return fin;
        } else if (h >= n && n >= 0) {
            return fin;
        }
        if (n > 0) {
            fin = val * fin;
            return findPower(val, n, h + 1, fin);
        } else {
            fin = 1 / val * fin;
            return findPower(val, n, h - 1, fin);
        }
    }
}
