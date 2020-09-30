package ComRealQuestion.vmware;

import java.util.*;

class numSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int K = sc.nextInt();
        int ans = 0;
        int[] count = new int[n+1];
        int[][] votes = new int[n][2];
        for (int i = 0; i < n; i++) {
            votes[i][0] = sc.nextInt();
            count[votes[i][0]]++;
            votes[i][1] = sc.nextInt();
            count[votes[i][1]]++;
        }

        for (int i = 1; i <= n-1; i++) {
            for (int j = i+1; j <= n; j++) {
                if(count[i] + count[j] < K) continue;
                int count_vote = 0;
                for (int[] vote : votes) {
                    if (vote[0] == i || vote[0] == j || vote[1] == i || vote[1] == j) count_vote++;
                }
                if(count_vote >= K) ans++;
            }
        }

        System.out.println(ans);
    }
}