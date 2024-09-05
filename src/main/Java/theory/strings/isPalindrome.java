package theory.strings;

public class IsPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindome1(s));
        System.out.println("===================");
        System.out.println(isPalindome2(s));
    }

    private static boolean isPalindome1(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        int i = 0, j = str.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(str.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindome2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if ((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z') || (t >= '0' && t <= '9')) {
                if (t >= 'A' && t <= 'Z') {
                    t = (char) (t - 'A' + 'a');
                }
                sb.append(t);
            }
        }
        String s = sb.toString();
        return sb.reverse().toString().equals(s);
    }

}
