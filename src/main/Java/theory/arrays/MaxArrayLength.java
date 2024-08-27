package theory.arrays;

public class MaxArrayLength {
    public static void main(String[] args) {

    }

    public int MaxArrayLength(int[] arr, int K){
        if (arr == null || arr.length == 0 || K < 0){
            return 0;
        }

        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length){
            if (sum == K){
                len = Math.max(len, right-left+1);
                sum -= arr[left++];
            }else if (sum < K){
                right++;
                if (right == arr.length){
                    break;
                }
                sum += arr[right];
            }else {
                sum -= arr[left++];
            }
        }
        return len;
    }
}
