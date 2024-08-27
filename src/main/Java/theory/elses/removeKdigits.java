package theory.elses;

public class removeKdigits {

    public static void main(String[] args) {

    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < sb.length(); i++) {
                if (sb.charAt(i) > sb.charAt(i - 1)) {
                    idx = j;
                }
            }
            sb.delete(idx, idx + 1);
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.delete(0, 1);
            }
        }
        return sb.toString();
    }
}
