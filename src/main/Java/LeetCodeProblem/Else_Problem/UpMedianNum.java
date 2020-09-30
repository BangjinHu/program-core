package LeetCodeProblem.Else_Problem;

public class UpMedianNum {

    public static void main(String[] args) {
        int[] arrOne = new int[]{1,2,3,4};
        int[] arrTwo = new int[]{3,4,5,6};
        System.out.println("两排序数组中的上中位数是：" + upMedianNum(arrOne, arrTwo));
    }

    public static int upMedianNum(int[] arrOne, int[] arrTwo){
//        if (arrOne == null || arrTwo == null || arrOne.length != arrTwo.length){
//            throw new RuntimeException("数组不合法");
//        }

        if (arrOne == null || arrTwo == null){
            throw new RuntimeException("数组不合法");
        }

        int startOne = 0;
        int endOne = arrOne.length - 1;

        int startTwo = 0;
        int endTwo = arrTwo.length - 1;

        int midOne = 0;
        int midTwo = 0;
        int offset = 0;

        while (startOne < endOne) {
            midOne = (startOne + endOne) / 2;
            midTwo = (startTwo + endTwo) / 2;

            offset = ((endOne - startOne + 1) & 1) ^ 1;
            //缩小上中位数的位置
            //二分查找
            //大数组的前半部分和小数组的后半部分，然后不断缩小中间位置得到最后的上中位数
            if (arrOne[midOne] > arrTwo[midTwo]) {
                endOne = midOne;
                startTwo = midTwo + offset;
            }else if (arrOne[midOne] < arrTwo[midTwo]){
                startOne = midOne + offset;
                endTwo = midTwo;
            }else {
                return arrOne[midOne];
            }
        }
        return Math.min(arrOne[startOne], arrTwo[startTwo]);
    }
}
