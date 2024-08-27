package theory.hashs;

import java.util.HashSet;
import java.util.Set;

public class RepeatedNTimes {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,5,2,5,3,5,4};
        System.out.println(repeatedNTimes(arr));
    }

    public static int repeatedNTimes(int[] A){
//        int[] result = new int[A.length];
//        for (int i = 0; i < A.length; i++){
//            //既然A中有N+1个不重复的元素，那么只要有两个重复的元素出现就可以认为该元素是重复了N次
//            result[i] = A[i++]++;
//            if (result[i] > 1){
//                //说明找到了该重复了N次的元素
//                return result[i];
//            }
//        }
//        return 0;

        Set<Integer> set = new HashSet<>();
        for (int i : A){
            if (set.contains(i)){
                return i;
            }else {
                set.add(i);
            }
        }
        return 0;
    }
}
