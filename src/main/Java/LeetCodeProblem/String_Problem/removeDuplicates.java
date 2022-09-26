package LeetCodeProblem.String_Problem;

public class removeDuplicates {

    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeDuplicates(str));
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (char c : str.toCharArray()) {
            if (length != 0 && c == sb.charAt(length - 1)) {
                sb.deleteCharAt(length - 1);
                length--;
            } else {
                sb.append(c);
                length++;
            }
        }
        return sb.toString();
    }
}
