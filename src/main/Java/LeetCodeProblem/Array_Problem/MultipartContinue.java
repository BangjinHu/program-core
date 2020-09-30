package LeetCodeProblem.Array_Problem;

import java.util.Arrays;

public class MultipartContinue {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,4};
        System.out.println(Arrays.toString(multipartContinue(arr)));
    }

    public static int[] multipartContinue(int[] arr){
        if (arr == null || arr.length < 2){
            return null;
        }

        int count = 0;
        int all = 1;
        for (int i = 0; i != arr.length; i++){
            if (arr[i] != 0){
                all *= arr[i];
            }else {
                count++;
            }
        }

        int result[] = new int[arr.length];
        if (count == 0){
            for (int i = 0; i != arr.length; i++){
                result[i] = all / arr[i];
            }
        }

        if (count == 1){
            for (int i = 0; i != arr.length; i++){
                if (arr[i] == 0){
                    result[i] = all;
                }
            }
        }
        return result;
    }
}
