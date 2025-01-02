package actual.YouZan;

public class Sqrt {

    public static void main(String[] args) {
        double x = 9.0;
        System.out.println("current value is : " + sqrt(x));
    }

    private static double sqrt(double x) {
        if (x == 1) {
            return 1.0;
        }
        double min = 0, max = x;
        while (max - min > 1) {
            double mid = (max + min) / 2;
            if (x / mid < mid) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;
    }
}
