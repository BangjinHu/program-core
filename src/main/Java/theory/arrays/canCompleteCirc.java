package theory.arrays;

public class canCompleteCirc {

    public static void main(String[] args) {

        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCirc(gas, cost));

    }

    public static int canCompleteCirc(int[] gas, int[] cost) {

        int[] dp = new int[gas.length];
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            if (i == 0) dp[i] = 0 - cost[gas.length - 1];
            else dp[i] = dp[i-1] + gas[i-1] - cost[i-1];
            if (dp[i] < dp[min]) min = i;
        }
        if (dp[gas.length - 1] + gas[gas.length - 1] < 0) return -1;
        else return min;
    }
}
