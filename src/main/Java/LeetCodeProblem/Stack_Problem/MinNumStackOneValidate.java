package LeetCodeProblem.Stack_Problem;

public class MinNumStackOneValidate {
    public static void main(String[] args) {
        MinNumStackOne minNumStack = new MinNumStackOne();
        int[] arr = new int[]{3,2,4,5,1};

        for (int i = 0; i < arr.length; i++){
            minNumStack.push(arr[i]);
        }

//        System.out.println(minNumStack.pop());
        System.out.println(minNumStack.getMin());
    }
}
