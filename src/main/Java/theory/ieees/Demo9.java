package theory.ieees;

import java.util.Scanner;

public class Demo9 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int B = in.nextInt();
        int X = in.nextInt();

        String[][] strs = new String[][]{{"abcdefdef"}, {"adbifdfdxd"}, {"edcjsjdldsiw"}};
        int max = 0;
        for (int m = 0; m < strs.length; m++){
            max = Math.max(max, strs[m].length);
            char[] chars = new char[max];
            for (int i = 0; i < strs.length - 1; i++){
                chars = strs[B][i].toCharArray();
            }
            char c = chars[X];
            System.out.println(c);
        }
    }
}
