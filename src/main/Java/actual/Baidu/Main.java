package actual.Baidu;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static final List<String> strList = new ArrayList<String>() {{
        add(" ");
        add(",.");
        add("abc");
        add("def");
        add("ghi");
        add("jkl");
        add("pqrs");
        add("tuv");
        add("wxyz");
    }};
    private static int count = 0;
    private static char prevCh;

    public static void main(String[] args) {
        // String str = "123";
        String str = "#22/23044444411";
        // String str = "1#22/222";
        process(str);

    }

    private static void findChOnStr(char str) {
        int strIndex = str - '0';
        if (strIndex == 0) {
            sb.append(strList.get(0));
        } else {
            int strLen = strList.get(strIndex).length();
            int index = count % strLen == 0 ? strLen - 1 : count % strLen - 1;
            sb.append(strList.get(strIndex).charAt(index));
        }
    }

    private static void process(String str) {
        boolean isEn = false;
        for (int i = 0; i < str.length(); i++) {
            char currCh = str.charAt(i);
            if (currCh == '#') {
                isEn = !isEn;
                if (count != 0) {
                    findChOnStr(prevCh);
                    prevCh = ' ';
                    count = 0;
                }
                continue;
            }
            if (isEn) {
                if (count == 0) {
                    if (currCh == '/') {
                        continue;
                    }
                    prevCh = currCh;
                    count = 1;
                } else if (prevCh != currCh) {
                    findChOnStr(prevCh);
                    if (i == str.length() - 1) {
                        findChOnStr(currCh);
                        break;
                    }
                    if (currCh == '/') {
                        count = 0;
                    } else {
                        prevCh = currCh;
                        count = 1;
                    }
                } else {
                    count++;
                    if (i == str.length() - 1) {
                        findChOnStr(currCh);
                    }
                }
            } else {
                if (currCh == '/') {
                    continue;
                }
                sb.append(currCh);
            }
        }
        System.out.println(sb);
    }


}
