package theory.elses;

public class GcD {
    public static void main(String[] args) {
        System.out.println(gCD(10, 20));
    }

    public static int gCD(int m, int n){
        return n == 0 ? m : gCD(n, m % n);
    }
}
