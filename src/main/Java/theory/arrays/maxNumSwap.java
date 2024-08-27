package theory.arrays;

public class maxNumSwap {

    public static void main(String[] args) {

    }

    // 交换数字中的两位使得结果得到最大值
    public int maxNumSwap(int num) {
        if (num == 0) {
            return 0;
        }
        char[] chars = String.valueOf(num).toCharArray();
        int[] maxIdx = new int[chars.length];
        int max = chars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] - '0' > chars[max] - '0') {
                max = i;
            }
            maxIdx[i] = max;
        }

        for (int i = 0; i < chars.length; i++) {
            int nV = chars[i] - '0';
            int mV = chars[maxIdx[i] - '0'];
            if (mV != nV) {
                chars[i] = (char) (mV + '0');
                chars[maxIdx[i]] = (char) (nV + '0');
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
