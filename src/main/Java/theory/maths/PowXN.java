package theory.maths;

public class PowXN {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        double res = pow(x, n);
        System.out.println(res);
    }

    private static double pow(double x, int n) {
        double ans = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                ans *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / ans : ans;
    }
}
