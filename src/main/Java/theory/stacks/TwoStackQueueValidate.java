package theory.stacks;

public class TwoStackQueueValidate {
    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        int[] arr = new int[]{3,5,2,8,7,1};
        for (int i = 0; i < arr.length; i++){
            twoStackQueue.add(arr[i]);
        }

        System.out.println(twoStackQueue.poll());
        System.out.println(twoStackQueue.peek());

    }
}
