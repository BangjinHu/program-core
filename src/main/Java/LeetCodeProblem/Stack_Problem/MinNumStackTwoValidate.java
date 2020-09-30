package LeetCodeProblem.Stack_Problem;

public class MinNumStackTwoValidate {
    public static void main(String[] args) {
        MinNumStackTwo minNumStackTwo = new MinNumStackTwo();
        int[] arr = new int[]{3,4,1,5,4,2};
        for (int i = 0; i < arr.length; i++){
            minNumStackTwo.push(arr[i]);
        }

//        System.out.println(minNumStackTwo.getMin());
        System.out.println(minNumStackTwo.pop());
    }
}
