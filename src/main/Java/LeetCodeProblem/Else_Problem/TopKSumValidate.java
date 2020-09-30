package LeetCodeProblem.Else_Problem;

public class TopKSumValidate {
    public static void main(String[] args) {

        TopKSum topKSum = new TopKSum();
        int[] arrOne = new int[]{1,2,3,4,5};
        int[] arrTwo = new int[]{3,5,7,9,11};
        int topK = 4;

        System.out.println("topK个数为：");
        for (int i = 0; i < topKSum.topKSum(arrOne, arrTwo, topK).length; i++){
            System.out.println(topKSum.topKSum(arrOne, arrTwo, topK)[i]);
        }
    }
}
