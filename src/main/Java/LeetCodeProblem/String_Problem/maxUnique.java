package LeetCodeProblem.String_Problem;

/**
 * 最长无重复字符子串
 */
public class maxUnique {
    public static void main(String[] args) {
        String str = "abcdab";
        System.out.println(maxUnique(str));
    }

    public static int maxUnique(String str){
        if (str == null || str.equals("")){
            return 0;
        }

        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++){
            map[i] = -1;
        }

        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i < chas.length; i++){
            pre = Math.max(pre, map[chas[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chas[i]] = i;
        }
        return len;
    }
}
