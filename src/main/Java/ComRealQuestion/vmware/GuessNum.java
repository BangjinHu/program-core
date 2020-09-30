package ComRealQuestion.vmware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GuessNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            Map<Integer, Integer> guessMapOne = new HashMap<>();
            Map<Integer, Integer> guessMapTwo = new HashMap<>();

            for (int i = 0; i < n; i++){
                guessMapOne.put(arr[i][0], guessMapOne.getOrDefault(arr[i][0], 0) + 1);
            }
            for (int i = 0; i < n; i++){
                guessMapTwo.put(arr[i][1], guessMapTwo.getOrDefault(arr[i][1], 0) + 1);
            }
            int[] mArr = new int[guessMapOne.size()];
            for (int m : guessMapOne.keySet()){
                int index = 0;
                mArr[index++] = m;
            }
            int count = 0;
            int[] nArr = new int[guessMapTwo.size()];
            for (int x : guessMapTwo.keySet()){
                if (count <= k){
                    int index = 0;
                    nArr[index++] = x;
                    count++;
                }
            }
            ArrayList<Integer> ansList = new ArrayList<>();
            for (int i = 0; i < Math.min(mArr.length, nArr.length); i++){
                if (mArr[i] != nArr[i]){
                    ansList.add(mArr[i]);
                    ansList.add(nArr[i]);
                }
            }
            System.out.println(ansList.size());
        }
    }
}
