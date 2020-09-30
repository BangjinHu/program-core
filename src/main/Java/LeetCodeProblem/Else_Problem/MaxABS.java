package LeetCodeProblem.Else_Problem;

public class MaxABS {
    public static void main(String[] args) {

        int[] arr = new int[]{2,7,3,1,1};
        System.out.println(maxABSOne(arr));
        System.out.println(maxABSTwo(arr));
        System.out.println(maxABSThree(arr));
    }

    public static int maxABSOne(int[] arr){
        int result = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i != arr.length - 1; i++){
            maxLeft = Integer.MIN_VALUE;
            for (int j = 0; j != i+1; j++){
                maxLeft = Math.max(arr[j], maxLeft);
            }

            maxRight = Integer.MIN_VALUE;
            for (int j = i+1; j != arr.length; j++){
                maxRight = Math.max(arr[j], maxRight);
            }

            result = Math.max(Math.abs(maxLeft - maxRight), result);
        }
        return result;
    }

    public static int maxABSTwo(int[] arr){
        int[] lArr = new int[arr.length];
        int[] rArr = new int[arr.length];
        lArr[0] = arr[0];
        rArr[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++){
            lArr[i] = Math.max(lArr[i-1], arr[i]);
        }

        for (int i = arr.length - 2; i > -1; i--){
            rArr[i] = Math.max(rArr[i+1], arr[i]);
        }

        int max = 0;
        for (int i = 0; i < arr.length - 1; i++){
            max = Math.max(max, Math.abs(lArr[i] - rArr[i+1]));
        }
        return max;
    }

    public static int maxABSThree(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(arr[i], max);
        }
        return max - Math.min(arr[0], arr[arr.length - 1]);
    }
}
