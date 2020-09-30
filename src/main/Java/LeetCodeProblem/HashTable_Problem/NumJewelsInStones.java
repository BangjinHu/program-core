package LeetCodeProblem.HashTable_Problem;

import java.util.HashMap;
import java.util.Map;

public class NumJewelsInStones {

    public static void main(String[] args) {

        String J = "ebd";
        String S = "bbb";

        System.out.println(numJewelsInStonesOne(J, S));
        System.out.println(numJewelsInStonesTwo(J, S));

    }

    public static int numJewelsInStonesOne(String J, String S){
        char[] jArr = J.toCharArray();
        char[] sArr = S.toCharArray();
        int result = 0;

        for (int i = 0; i < jArr.length; i++){
            for (int j = 0; j < sArr.length; j++){
                if (jArr[i] == sArr[j]){
                    result++;
                }
            }
        }
        return result;
    }

    //方法二较方法一减少了时间复杂度
    public static int numJewelsInStonesTwo(String J, String S){
        int num = 0;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++){
            //key=位置i对应的数，value=null
            map.put(J.charAt(i), null);
        }

        for (int j = 0; j < S.length(); j++){
            //是否包含key
            if (map.containsKey(S.charAt(j))){
                num++;
            }
        }
        return num;
    }
}
