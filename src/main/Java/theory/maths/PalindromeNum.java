package theory.maths;

public class PalindromeNum {

    public static void main(String[] args) {
        int num = 123311;
        System.out.println("current number is palindrome? -> " + isPalindrome(num));
    }

    private static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        int cur = 0;
        int curNum = num;
        while (curNum > 0) {
            cur = cur * 10 + curNum % 10;
            curNum /= 10;
        }
        return cur == num;
    }
}
