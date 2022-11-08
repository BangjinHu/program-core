package LeetCodeProblem.Array_Problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maxDepth {

    public static void main(String[] args) {
        /**
         * [[1,0],[2,0],[3,1],[3,2]]
         */
//        List<List<Integer>> argList = new ArrayList<>(){{add(1); add(0)}, {}};
        List<List<Integer>> argList = new ArrayList<>();
        List<Integer> numsList1 = new ArrayList<>();
        numsList1.add(1);
        numsList1.add(0);
        argList.add(numsList1);
        List<Integer> numsList2 = new ArrayList<>();
        numsList2.add(2);
        numsList2.add(0);
        argList.add(numsList2);
        List<Integer> numsList3 = new ArrayList<>();
        numsList3.add(3);
        numsList3.add(1);
        argList.add(numsList3);
        List<Integer> numsList4 = new ArrayList<>();
        numsList4.add(3);
        numsList4.add(2);
        argList.add(numsList4);

        List<Integer> ansList = maxDepth(argList);
        for (int i = 0; i < ansList.size(); i++) {
            System.out.print(ansList.get(i) + " ");
        }

    }

    public static List<Integer> maxDepth(List<List<Integer>> argList) {

        if (argList == null || argList.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> ansList = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < argList.size(); i++) {
            for (int j = 0; j < argList.get(i).size(); j++) {
                countMap.put(argList.get(i).get(1), countMap.getOrDefault(argList.get(i).get(1), 0) + 1);
            }
        }
        int count = countMap.values().size();
        while (count >= 0) {
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                // 最大频次
                if (entry.getValue() == count) {
                    ansList.add(entry.getKey());
                }
            }
            count--;
        }
        return ansList;
    }
}
