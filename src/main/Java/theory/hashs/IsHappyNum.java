package theory.hashs;

import java.util.HashSet;

public class IsHappyNum {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappyNum(n));
    }

    private static boolean isHappyNum(int n) {
        HashSet<Integer> compareSet = new HashSet<>();
        while (n != 1 && !compareSet.contains(n)) {
            compareSet.add(n);
            n = squareNum(n);
        }
        return n == 1;
    }

    private static int squareNum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
