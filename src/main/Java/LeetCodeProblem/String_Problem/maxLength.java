package LeetCodeProblem.String_Problem;

public class maxLength {
    public static void main(String[] args) {
        String str = "()";
        System.out.println(maxLength(str));
    }

    public static int maxLength(String str){
        if (str == null || str.equals("")){
            return 0;
        }

        char[] chas = str.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chas.length; i++){
            //遍历得到的值如果是右括号的话
            if (chas[i] == ')'){
                pre = i - dp[i-1] - 1;
                if (pre >= 0 && chas[pre] == '('){
                    //从这里我们可以看出如果有效，则长度最小是2
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre-1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
