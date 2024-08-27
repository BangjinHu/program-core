package actual.BeiKe;

import java.util.Scanner;
import java.util.Stack;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int maxLength = 0;
        for(int i = 0; i < n; i++){
            //最长回文串
            int index = i;
            for(int k = i + 1; k < n; k++){
                if(isMatch(str.substring(i, k - i))){
                    maxLength++;
                }
            }
        }
        int ans = maxLength + str.length() - 2 * maxLength + 1;
        System.out.println(ans);
    }

    public static boolean isMatch(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length() / 2; i++){
            stack.push(str.charAt(i));
        }
        int index = str.length() / 2 + 1;
        for(; index < str.length(); index++){
            if(str.charAt(index) != stack.pop()){
                return false;
            }
        }
        return true;
    }
}
