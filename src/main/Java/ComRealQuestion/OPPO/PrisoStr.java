package ComRealQuestion.OPPO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PrisoStr {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            List<String> tmpList = new ArrayList<>();
            List<List<String>> ansList = new ArrayList<>();
            for (int i = 0; i < str.length(); i++){
                int start = i + 1;
                while (start < str.length()){
                    if (isMatch(str.substring(i, start - i + 1))){
                        tmpList.add(str.substring(i, start - i + 1));
                        ansList.add(tmpList);
                    }
                    start++;
                }
            }
            System.out.println(ansList);
        }
    }

    public static boolean isMatch(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length() / 2; i++){
            stack.push(str.charAt(i));
        }
        for (int k = str.length() / 2 + 1; k < str.length(); k++){
            if (str.charAt(k) != stack.pop()){
                return false;
            }
        }
        return true;
    }
}
