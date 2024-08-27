package actual.Didi;

import java.util.Scanner;
public class ReverseKStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String K = sc.nextLine();
            int k = Integer.valueOf(K);
//            int k = sc.nextInt();
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i += k){
                if (i + k > str.length()){
                    sb.append(new StringBuilder(str.substring(i)).reverse());
                }else {
                    sb.append(new StringBuilder(str.substring(i, i + k)).reverse());
                }
            }
            System.out.println(sb.toString());
        }
    }
}
