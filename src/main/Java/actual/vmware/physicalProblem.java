package actual.vmware;


import java.util.Scanner;

public class physicalProblem {

    static double x = 0;
    static double y = 0;
    static int direction = 0;
    static double n = 0;
    static double r = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextDouble();
        int m = sc.nextInt();
        r = sc.nextDouble();

        for(int i=0; i<m; i++) {
            go(r);
            System.out.println(String.format("%.2f", x) + " " + String.format("%.2f", y));
        }
    }

    public static void go(double range) {
        if(direction == 0) {
            x += range;
            if(x > n) {
                double next_range = x - n;
                x = n;
                direction = 1;
                go(next_range);
            }
        } else if(direction == 1) {
            y += range;
            if(y > n) {
                double next_range = y - n;
                y = n;
                direction = 2;
                go(next_range);
            }
        } else if(direction == 2) {
            x -= range;
            if(x < 0) {
                double next_range = 0 - x;
                x = 0;
                direction = 3;
                go(next_range);
            }
        } else {
            y -= range;
            if(y < 0) {
                double next_range = 0 - y;
                y = 0;
                direction = 0;
                go(next_range);
            }
        }
    }
}
