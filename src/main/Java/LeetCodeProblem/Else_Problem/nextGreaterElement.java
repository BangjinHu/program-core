package LeetCodeProblem.Else_Problem;

public class nextGreaterElement {

    public static void main(String[] args) {
        int n = 21;
        System.out.println(nextGreaterElement(n));
    }

    /**
     * 下一个更大元素，类似于下一个排列
     * @param n
     * @return
     */
    public static int nextGreaterElement(int n) {
        char[] chars = ("" + n).toCharArray();
        int i = chars.length - 2;
        while (i >= 0 && chars[i + 1] <= chars[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = chars.length - 1;
        while (j >= 0 && chars[j] <= chars[i]) {
            j--;
        }
        swap(chars, i, j);
        reverse(chars, i + 1);
        return Integer.parseInt(new String(chars));
    }

    private static void swap(char[] chars, int m, int n) {
        char t = chars[m];
        chars[m] = chars[n];
        chars[n] = t;
    }

    private static void reverse(char[] chars, int index) {
        int i = index;
        int j = chars.length - 1;
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }
}
