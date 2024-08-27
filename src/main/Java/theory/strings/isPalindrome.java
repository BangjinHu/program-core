package theory.strings;

import java.util.Stack;

public class isPalindrome {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
////            String str = sc.next();
//            String s = "A man, a plan, a canal: Panama";
//            System.out.println(isPa(s));
//        }
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPa(s));
    }

    public static boolean isPa(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char t = str.charAt(i);
            if ((t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z') || (t >= '0' && t <= '9')){
                if (t >= 'A' && t <= 'Z'){
                    t = (char)(t - 'A' + 'a');
                }
                sb.append(t);
            }
        }
        String s = sb.toString();
        if (sb.reverse().toString().equals(s)){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isPalindrome(String str){
        if (null == str || str.length() == 0){
            return false;
        }
        String s = str.toUpperCase();
//        Map<Integer, Character> strCountMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() / 2; i++){
//            strCountMap.put(i, s.charAt(i));
            stack.push(s.charAt(i));
        }
        for (int i = s.length() / 2; i < s.length(); i++){
//            if (s.charAt(i) != strCountMap.get(s.length() / 2 - i - 1)){
//                return false;
//            }
            if (stack.pop() != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
