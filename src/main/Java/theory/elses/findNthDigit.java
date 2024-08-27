package theory.elses;

public class findNthDigit {

    public static void main(String[] args) {
        int n = 11;
        System.out.println(findNthDigit(n));
    }

    public static int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            sb.append(i + 1);
//            if (sb.length() == n) {
//                return sb.charAt(sb.length() - 1);
//            }
//        }
//        return -1;

        int length = 1, base = 9;
        while (n > (long) length * base) {
            n -= length * base;
            length++;
            base *= 10;
        }
        int start = base / 9;
        int num = start + (n - 1) / length;
        int dgtIdx = (n - 1) % length;
        return String.valueOf(num).charAt(dgtIdx) - '0';
    }
}
