package ComRealQuestion.Baidu;

import java.util.Scanner;

public class MaxSubStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            /*char c = chars[chars.length - 1];
            for (int i = chars.length - 1; i >= 0; i--){
                if (chars[i] >= c){
                    sb.append(chars[i]);
                    c = chars[i];
                }
            }
            System.out.println(sb.reverse());*/

            char c = chars[0];
            for (int i = 0; i < chars.length; i++){
                if (chars[i] >= c){
                    sb.append(chars[i]);
                    c = chars[i];
                }
            }
            System.out.println(sb.toString());
        }
    }
}
