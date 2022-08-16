package ComRealQuestion.YouZan;

import java.util.HashSet;

public class FairCandySwap {

    public static void main(String[] args) {

    }

    public int[] fairCandySwap (int[] A, int[] B) {
        // write code here
        int sum = 0;
        HashSet<Integer> tmpSet = new HashSet<>();
        for (int i : B){
            sum += i;
            tmpSet.add(i);
        }
        for (int x : A){
            sum -= x;
        }
        for (int x : A){
            if (tmpSet.contains(x + sum / 2)){
                return new int[]{x, x + sum / 2};
            }
        }
        return new int[]{};
    }
}
