package theory.elses;

public class palindromNum {

    public static void main(String[] args) {
        int num = 121;
        System.out.println(isPalindromNum(num));
    }

    public static boolean isPalindromNum(int num) {
        if (num < 0) {
            return false;
        }
        int length = 1;
        while (num / length > 10) {
            length *= 10;
        }
        while (num > 0) {
            int h = num / length;
            int t = num % 10;
            if (h != t) {
                return false;
            } else {
                num = (num % length) / 10;
                length /= 100;
            }
        }
        return true;
    }
}
