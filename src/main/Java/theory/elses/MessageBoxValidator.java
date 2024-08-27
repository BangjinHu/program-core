package theory.elses;

public class MessageBoxValidator {
    public static void main(String[] args) {

        int[] nums = new int[]{2,1,4,5,7,3,9,8,6};
        MessageBox messageBox = new MessageBox();
        for (int i = 0; i < nums.length; i++){
            messageBox.receive(nums[i]);
        }
    }
}
