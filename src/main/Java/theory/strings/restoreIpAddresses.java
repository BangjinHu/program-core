package theory.strings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class restoreIpAddresses {

    public static void main(String[] args) {

    }

    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        List<String> ansList = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        if (length > 12 || length < 4) {
            return ansList;
        }
        dfs(s, length, 0, 4, path, ansList);
        return ansList;
    }

    private void dfs(String s, int length, int begin, int residue, Deque<String> path, List<String> ansList) {
        if (begin == length) {
            if (residue == 0) {
                ansList.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= length) {
                break;
            }
            if (residue * 3 < length - i) {
                continue;
            }
            if (isIPv4Valid(s, begin, i)) {
                String curIp = s.substring(begin, i + 1);
                path.addLast(curIp);
                dfs(s, length, i + 1, residue - 1, path, ansList);
                path.removeLast();
            }
        }
    }

    private boolean isIPv4Valid(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }


}
