package theory.arrays;

import java.util.HashSet;

public class IntegratedArrayTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{5,5,3,2,6,4,3};
        System.out.println(IntegratedArrayTwo(arr));
    }

    public static int IntegratedArrayTwo(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }

        int len = 0;
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++){
                //包括重复元素与否
                if (set.contains(arr[j])){
                    break;
                }
                //没有重复元素加入
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);

                if (max - min == j - i){
                    len = Math.max(len, j - i + 1);
                }
            }
            set.clear();
        }
        return len;
    }
}
