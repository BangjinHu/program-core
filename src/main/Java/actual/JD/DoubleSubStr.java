package actual.JD;

import java.util.Scanner;

public class DoubleSubStr {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String subStr = "";
            int length = str.length();
            int index = 0;
            for (int i = 1; i < length; i++){
                String subLeft = str.substring(0, i);
                String subRight = str.substring(length - i, length);
                if (subLeft.equals(subRight)){
                    subStr = subRight;
                    index = i;
                }
            }
            subStr = str.substring(index);
            System.out.println(str + subStr);
        }
    }
}
