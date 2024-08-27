package theory.elses;

//丢棋子问题
public class ThrewChessQuestion {

    public static void main(String[] args) {
        int nLevel = 105;
        int kChess = 2;

//        System.out.println(threwChessQuestionOne(nLevel, kChess));
        System.out.println(threwChessQuestionTwo(nLevel, kChess));

    }

    //方法一：时间复杂度非常高，O(N!)
    public static int threwChessQuestionOne(int nLevel, int kChess) {
        if (nLevel < 1 || kChess < 1){
            return 0;
        }

        return processOne(nLevel, kChess);
    }

    public static int processOne(int nLevel, int kChess){
        if (nLevel == 0){
            return 0;
        }

        if (kChess == 1){
            return nLevel;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i != nLevel + 1; i++){
            if (i == nLevel){

            }
            //比较如果在第i层碎了和没碎两种情况下的最大值，然后取得所有可能中的最小值
            min = Math.min(min, Math.max(processOne(i - 1, kChess - 1), processOne(nLevel - i, kChess)));
        }
        return min + 1;
    }

    //方法二：时间复杂度是O(N*N*K)
    public static int threwChessQuestionTwo(int nLevel, int kChess){
        if (nLevel < 1 || kChess < 1){
            return 0;
        }

        if (kChess == 1){
            return nLevel;
        }

        int[][] dp = new int[nLevel + 1][kChess + 1];
        for (int i = 1; i != dp.length; i++){
            dp[i][1] = i;
        }

        for (int i = 1; i != dp.length; i++){
            for (int j = 2; j != dp[0].length; j++){
                int min = Integer.MAX_VALUE;
                for (int k = 1; k != i+1; k++){
                    min = Math.min(min, Math.max(dp[k-1][j-1], dp[i-k][j]));
                }

                dp[i][j] = min + 1;
            }
        }
        return dp[nLevel][kChess];
    }
}
