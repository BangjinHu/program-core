package actual.YouZan;

import java.util.Scanner;

public class DFS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        sc.nextLine();
        String numstr = sc.nextLine();
        String[] numstrs = numstr.split(",");

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nums[i] = Integer.parseInt(numstrs[i].substring(1).trim());
            } else if (i == n - 1) {
                nums[i] = Integer.parseInt(numstrs[i].substring(0, numstrs[i].length() - 1).trim());
            } else {
                nums[i] = Integer.parseInt(numstrs[i].trim());
            }
        }
        System.out.println(dfs(nums));
    }

    private static int dfs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (visited[i] || visited[j]) {
                    continue;
                }
                if (nums[j] * 2 > nums[i]) {
                    ans += 1;
                    visited[i] = true;
                    visited[j] = true;
                }
            }
        }
        return ans;
    }
}
