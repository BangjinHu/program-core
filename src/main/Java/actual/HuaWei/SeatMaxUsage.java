package actual.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatMaxUsage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayList<SeatPair> pairList = new ArrayList<>();
        for (int i = 0; i < x; ++i) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            pairList.add(new SeatPair(start, end));
        }
        int maxUsageNum = maxSeatUsageNum(x, n, m, pairList);
        System.out.println("current max usage seat's num is: " + maxUsageNum);
    }

    // 最大作为利用数
    public static int maxSeatUsageNum(int x, int n, int m, List<SeatPair> seatPairList) {
        int ans = 0;
        // 枚举所有乘客存在的可能性，共2^x种可能
        for (int i = 0; i < (1 << x); ++i) {
            int[] cnt = new int[n];
            boolean flag = true;
            int res = 0;
            for (int j = 0; flag && j < x; ++j) {
                // 判断当前乘客是否在当前组合中
                if ((i >> j & 1) == 1) {
                    for (int k = seatPairList.get(j).x; flag && k < seatPairList.get(j).y; ++k) {
                        ++cnt[k];
                    }
                    res += seatPairList.get(j).y - seatPairList.get(j).x;
                }
            }
            // 检查每个站是否超载
            for (int j = 0; j < n; ++j) {
                if (cnt[j] > m) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }


    static class SeatPair {
        int x;
        int y;

        public SeatPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
