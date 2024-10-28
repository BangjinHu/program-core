package theory.backtraces;

import java.util.ArrayList;
import java.util.List;

public class NPrint {
    public static void main(String[] args) {

        int n = 3;
        List<List<Integer>> ansList = printNums(n);
        for (int i = 0; i < ansList.size(); i++) {
            for (int j = 0; j < ansList.get(i).size(); j++) {
                System.out.print(ansList.get(i).get(j));
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> printNums(int n) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (n <= 1) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(n);
            ansList.add(tmpList);
            return ansList;
        }
        printNums(n, new ArrayList<>(), ansList);
        return ansList;
    }

    private static void printNums(int target, List<Integer> tmpList, List<List<Integer>> ansList) {
        if (tmpList.size() == target) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = 1; i <= target; i++) {
            if (!tmpList.contains(i)) {
                tmpList.add(i);
                printNums(target, tmpList, ansList);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }

}
