package theory.hashs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InterSection {
    public static void main(String[] args) {
        int[] numsOne = new int[]{1,2,2,1};
        int[] numsTwo = new int[]{2,2};

//        int len = Math.max(numsOne.length, numsTwo.length);
//        for (int i = 0; i < len; i++){
//            System.out.println(interSection(numsOne, numsTwo)[i]);
//        }

        System.out.println(interSection(numsOne, numsTwo)[0]);
    }

    //求两个数组的交集
    public static int[] interSection(int[] numsOne, int[] numsTwo){
        //暴力
        int maxLen = Math.max(numsOne.length, numsTwo.length);
        int[] result = new int[maxLen];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numsOne.length; i++){
            for (int j = 0; j < numsTwo.length; j++){
                if (numsOne[i] == numsTwo[j]){
                    set.add(numsOne[i]);
                }
            }
        }

        Iterator<Integer> iterator = set.iterator();
        int k = 0;
        while (iterator.hasNext()){
            result[k++] = iterator.next();
        }
        return result;
    }
}
