package LeetCodeProblem.Else_Problem;

import java.util.HashSet;

//最小不可组成和
public class UnformedSumOne {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5};
        System.out.println(unformedSumOne(arr));
    }

    public static int unformedSumOne(int[] arr){
        if (arr == null || arr.length == 0){
            return 1;
        }

        HashSet<Integer> set = new HashSet<>();
        process(arr, 0, 0, set);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i != arr.length; i++){
            min = Math.min(min, arr[i]);
        }

        for (int i = min + 1; i != Integer.MIN_VALUE; i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return 0;
    }

    public static void process(int[] arr, int i, int sum, HashSet<Integer> set){
        if (i == arr.length){
            set.add(sum);
            return;
        }

        process(arr, i+1, sum, set);
        process(arr, i+1, sum + arr[i], set);
    }
}
