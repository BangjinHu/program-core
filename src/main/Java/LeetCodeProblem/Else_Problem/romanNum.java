package LeetCodeProblem.Else_Problem;

public class romanNum {

    public static void main(String[] args) {
        int num = 1994;
        String ans = numToRomanNum(num);
        System.out.println(ans);
    }

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param num
     * @return
     */
    public static String numToRomanNum(int num) {

        int[] valus = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rNums = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String ans = "";
        for (int i = 0; i < valus.length; i++) {
            while (num >= valus[i]) {
                num -= valus[i];
                ans += rNums[i];
            }
        }
        return ans;
    }
}
