package LeetCodeProblem.DynamicPlan;

public class MinCoins {

    public int minCoins(int[] arr, int aim){
        if (arr == null || arr.length == 0 || aim < 0){
            return -1;
        }

        return process(arr, 0, aim);
    }

    public int process(int[] arr, int i, int rest){

        if (i == arr.length){
            return rest == 0 ? 0 : -1;
        }

        int res = -1;
        for (int k = 0; k * arr[i] <= rest; k++){
            int next = process(arr, i+1, rest - k*arr[i]);
            if (next != -1){
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;

    }
}
