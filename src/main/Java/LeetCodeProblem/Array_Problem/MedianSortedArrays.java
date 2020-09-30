package LeetCodeProblem.Array_Problem;

public class MedianSortedArrays {

    public static double medianSortedArrays(int[] numsOne, int[] numsTwo){

        //1.将两个数组归并排序

        //其中有一个数组为空的情况
        int[] nums = new int[numsOne.length + numsTwo.length];
        if (numsOne.length == 0){
            if (numsTwo.length % 2 == 0){
                //2.返回不空数组且为偶数个数的中位数
                return (numsTwo[numsTwo.length / 2 - 1] + numsTwo[numsTwo.length / 2]) / 2;
            }else {
                return numsTwo[numsTwo.length / 2];
            }
        }

        if (numsTwo.length == 0){
            if (numsOne.length % 2 == 0){
                return (numsOne[numsOne.length / 2 - 1] + numsOne[numsOne.length / 2]) / 2;
            }else {
                return numsOne[numsOne.length / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (numsOne.length + numsTwo.length)){
            if (i == numsOne.length){
                while (j != numsTwo.length){
                    nums[count++] = numsTwo[j++];
                }
                break;
            }

            if (j == numsTwo.length){
                while (i != numsOne.length){
                    nums[count++] = nums[i++];
                }
                break;
            }

            if (nums[i] <numsTwo[j]){
                nums[count++] = numsOne[i++];
            }else {
                nums[count++] = numsTwo[j++];
            }
        }

        if (count % 2 == 0){
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        }else {
            return nums[count / 2];
        }
    }

    public static void main(String[] args) {
        int[] numsOne = new int[]{1,2,3,4,5};
        int[] numsTwo = new int[]{4,5,6,7,8,9};
        System.out.println(medianSortedArrays(numsOne, numsTwo));
    }
}
