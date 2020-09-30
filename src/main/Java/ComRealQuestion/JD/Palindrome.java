package ComRealQuestion.JD;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            for (int i = 0; i < str.length(); i++){
                if (isPalind(str.substring(i, str.length() - 1))){
                    System.out.println(str.length()+i);
                    break;
                }
            }
        }
    }

    public static boolean isPalind(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length() / 2; i++){
            stack.push(str.charAt(i));
        }
        for (int i = str.length() / 2 + 1; i < str.length(); i++){
            if (str.charAt(i) != stack.pop()){
                return false;
            }
        }
        return true;
    }
}
