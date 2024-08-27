package theory.arrays;

import java.util.HashMap;
import java.util.Map;

public class ArrayMaxLength {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,1,0};
        int K = 6;
        System.out.println(arrayMaxLength(arr, K));
    }

    public static int arrayMaxLength(int[] arr, int K){
        if (arr == null || arr.length == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (map.containsKey(sum-K)){
                len = Math.max(i-map.get(sum - K), len);
            }

            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }
}
