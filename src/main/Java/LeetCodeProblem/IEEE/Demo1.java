package LeetCodeProblem.IEEE;

import java.util.HashMap;
import java.util.Map;

public class Demo1 {

    public static void main(String[] args) {
        int N = 59;
        int A = 10;
        int B = 8;
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int temp_A = 0;
        int temp_B = 0;

        int numA = 0;
        int numB = 0;
        int temp = 0;
        while (N > 0){
            temp = N / A;
            map.put("A", temp);
            int tempB = N - temp * A;

            if (tempB == 0){
                System.out.println("YES");
                numA = map.get("A");
                for (int i = 0; i < numA; i++){
                    sb.append(numA);
                    sb.append(" ");
                }
                System.out.println(sb.toString());
            }
            if(tempB % B == 0){
                temp_B = temp / B;
                map.put("B", temp_B);
                System.out.println("YES");

                numA = map.get(A);
                numB = map.get(B);

                for (int i = 0; i < numA; i++){
                    sb.append(numA);
                    sb.append(" ");
                }
                for (int j = 0; j < numB; j++){
                    sb.append(numB);
                    sb.append(" ");
                }
                System.out.println(sb.toString());
            }else {
                System.out.println("YES");
                map.put("B", temp / B);
                int t = map.get("A");
                int m = map.get("B");
                for (int i = 0; i < t; i++){
                    sb.append(t);
                    sb.append(" ");
                }
                for (int j = 0; j < m; j++){
                    sb.append(m);
                    sb.append(" ");
                }
                System.out.println(sb.toString());
            }
        }
    }

}
