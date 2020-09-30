package ComRealQuestion.DouYu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeleteCNum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < n; i++){
                countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            }
            for (int k : countMap.keySet()){
                System.out.print(k + " ");
            }
        }
    }
}
