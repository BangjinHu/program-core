package LeetCodeProblem.Array_Problem;

import java.util.Arrays;

public class IntegratedArrayOne {
    public static void main(String[] args) {
        int[] arr = new int[]{5,5,3,2,6,4,3};
        System.out.println(IntegratedArray(arr));
    }

    public static int IntegratedArray(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }

        int len = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i; j < arr.length; j++){
                if (isIntegratedArray(arr, i, j)){
                    //如果是可整合数组的话返回子数组的长度
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    public static boolean isIntegratedArray(int[] arr, int left, int right){
        //将所有的子数组复制成新的数组
        int[] arrTmp = Arrays.copyOfRange(arr, left, right+1);
        //对新的数组排序，二分排序？
        Arrays.sort(arrTmp);
        //然后判断子数组中的元素的前后相邻元素是否相差1
        for (int i = 1; i < arrTmp.length; i++){
            if (arrTmp[i-1] != arrTmp[i]-1){
                return false;
            }
        }
        return true;
    }
}
