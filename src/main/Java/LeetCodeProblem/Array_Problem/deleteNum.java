package LeetCodeProblem.Array_Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class deleteNum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> numsList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                numsList.add(i+1);
            }
            int[] lows = new int[2 * numsList.size()];
            int[] highs = new int[2 * numsList.size()];
            List<Integer> ansList = numsList;
            int low = 0, high = 0;
            while (lows.length + highs.length < numsList.size() - 1) {
                int i = 0;
                while (i < ansList.size()) {
                    lows[low++] = i;
                    ansList.remove(i);
                    i += 2;
                }
                int j = ansList.size() - 1;
                while (j >= 0) {
                    highs[high++] = j;
                    ansList.remove(j);
                    j -= 2;
                }
            }
            System.out.println(ansList.get(0));
        }

//            boolean flag = false;
//            while (numsList.size() > 1) {
//                if (!flag) {
//                    i = (i + 1) % numsList.size();
//                } else {
//                    i = (numsList.size() - i) % numsList.size();
//                }
//                if (i >= numsList.size() || i < 0) {
//                    flag = !flag;
//                }
//                numsList.remove(i);
//            }
//            System.out.println(numsList.get(0));
        }

    }



