package theory.elses;

import java.util.Arrays;

//进阶：已知正数数组arr中肯定有1这个数，更快的得到最小不可组成和
//这一个题是由给出的案例规律得到的

public class UnformedSumThree {
    public static void main(String[] args) {
        int[] arr = new int[]{3,8,1,2};
        System.out.println(unformedSumThree(arr));
    }

    public static int unformedSumThree(int[] arr){
        if (arr == null || arr.length == 0){
            return 1;
        }

        //排序，时间复杂度O(N*logN)
        Arrays.sort(arr);
        int range = 0;
        for (int i = 0; i != arr.length; i++){
            if (arr[i] > range + 1){
                return range + 1;
            }else {
                range += arr[i];
            }
        }
        return range+1;
    }
}
