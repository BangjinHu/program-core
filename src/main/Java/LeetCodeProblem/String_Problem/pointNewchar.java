package LeetCodeProblem.String_Problem;

public class pointNewchar {
    public static void main(String[] args) {
        String s = "aaABCDEcBCg";
        System.out.println(pointNewchar(s,4));
    }

    public static String pointNewchar(String s, int k){
        if (s == null || s.equals("") || k < 0 || k >= s.length()){
            return "";
        }
        char[] chas = s.toCharArray();
        int nNum = 0;
        //向左统计连续出现大写字母的数量
        for (int i = k-1; i >= 0; i--){
            if (!(chas[i] >= 'A' && chas[i] <= 'Z')){
                break;
            }
            nNum++;
        }

        //如果统计的大写字母为奇数
        if ((nNum & 1) == 1){
            return s.substring(k-1, k+1);
        }

        //统计的大写字母是偶数且第k个是大写字母
        if (chas[k] >= 'A' && chas[k] <= 'Z'){
            return s.substring(k, k+2);
        }

        //统计的大写字母个数是偶数且第k个是小写字母
        return String.valueOf(chas[k]);
    }
}
