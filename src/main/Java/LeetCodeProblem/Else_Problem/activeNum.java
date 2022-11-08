package LeetCodeProblem.Else_Problem;

import java.util.ArrayList;
import java.util.List;

public class activeNum {

    public static void main(String[] args) {

    }

    public boolean isActiveNum(String num) {
        int n = num.length();
        List<List<Integer>> ansList = new ArrayList<>();
        return dfs(num,0, n, ansList);
    }

    private boolean dfs(String num, int start, int n, List<List<Integer>> ansList) {

        int size = ansList.size();
        if (start == n) {
            return size >= 3;
        }
        int max = num.charAt(start) == '0' ? start + 1 : n;
        List<Integer> curList = new ArrayList<>();
        for (int i = start; i < max; i++) {
            curList.add(0, num.charAt(i) - '0');
            if (size < 2 || check(ansList.get(size - 2), ansList.get(size - 1), curList)) {
                ansList.add(curList);
                if (dfs(num, start + 1, n, ansList)) {
                    return true;
                }
                ansList.remove(ansList.size() - 1);
            }
        }
        return false;
    }

    private boolean check(List<Integer> tList, List<Integer> fList, List<Integer> curList) {

        List<Integer> ans = new ArrayList<>();
        int tNum = 0;
        for (int i = 0; i < tList.size() || i < fList.size(); i++) {
            if (i < tList.size()) {
                tNum += tList.get(i);
            }
            if (i < fList.size()) {
                tNum += fList.get(i);
            }
            ans.add(tNum % 10);
            tNum /= 10;
        }
        if (tNum > 0) {
            ans.add(tNum);
        }
        boolean flag = curList.size() == ans.size();
        for (int i = 0; i < curList.size() && flag; i++) {
            if (curList.get(i) != ans.get(i)) {
                flag = false;
            }
        }
        return flag;
    }
}
