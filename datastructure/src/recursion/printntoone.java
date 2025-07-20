package recursion;

public class printntoone {
    public static void main(String args[]) {
        System.out.println(recursion(5));
    }

    public static int recursion(int n) {

        if(n==1) {
            return 1;
        }
        return n * recursion(n - 1);
    }
}
