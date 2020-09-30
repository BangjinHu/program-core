package LeetCodeProblem.Else_Problem;

public class MedianHolderValidator {
    public static void main(String[] args) {
        MedianHolder medianHolder = new MedianHolder();
        int[] nums = new int[]{5,3,6,7};
        for (int i = 0; i < nums.length; i++){
            medianHolder.addNumber(nums[i]);
            System.out.println(medianHolder.getMedian());
        }
    }



}
