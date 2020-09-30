package ComRealQuestion.WanmeiSJ;

import java.util.Scanner;

public class ReverseStr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int count = 0;
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == '_'){
                    count++;
                }
            }
            if (count == str.length()){
                System.out.println(str);
            }
            if (str == null || str.length() == 0){
                System.out.println(" ");
            }

            String[] strs = str.split("_");
            String ans = "";
            for (int i = 0; i < strs.length; i++){
                StringBuilder sb = new StringBuilder();
                for (int k = strs[i].length() - 1; k >= 0; k--){
                    sb.append(strs[i].charAt(k));
                }
                if (i == strs.length - 1){
                    ans += sb.toString();
                }else {
                    ans += sb.toString() + "_";
                }
            }
            System.out.println(ans);
        }
    }
}
