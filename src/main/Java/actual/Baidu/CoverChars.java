package actual.Baidu;

import java.util.Arrays;
import java.util.Scanner;

public class CoverChars {

    //覆盖字符
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String pattern = sc.nextLine();
            char[] chars = str.toCharArray();
            char[] pchars = pattern.toCharArray();
            Arrays.sort(pchars);
            int n = str.length();
            int pn = pattern.length();
            for (int i = 0, j = pn - 1; i < n && j >= 0; i++){
                if (chars[i] < pchars[j]){
                    chars[i] = pchars[j];
                    j--;
                }
            }
            System.out.println(new String(chars));
        }
    }
}
