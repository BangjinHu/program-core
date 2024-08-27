package theory.hashs;

import java.util.ArrayList;
import java.util.List;

public class FindWords {
    public static void main(String[] args) {

//        String[] strs = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] strs = new String[]{"asdfghjkl","qwertyuiop","zxcvbnm"};
        for (String s : findWords(strs)){
            System.out.println(s);
        }
    }

    public static String[] findWords(String[] words){

        if (words == null){
            return null;
        }

        List<String> result = new ArrayList<>();
        String[] lines = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (String word : words){
            if (compareStr(word.toLowerCase(), lines)){
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static boolean compareStr(String word, String[] lines){
        boolean result_boolean = true;
        String find = null;

        //确定要比较的数是否出现在所知行中
        for (String line : lines){
            //确定word中首字母是否在一个行或多个行中出现
            if (line.indexOf(word.charAt(0)) > -1){
                find = line;
                break;
            }
        }

        if (find == null){
            result_boolean = false;
            return result_boolean;
        }

        //然后比较返回所知行是否包括要比较字符串所有字符
        for (int i = 1; i < word.length(); i++){
            //如果输入的字符不是所有的都存在比较的字符串中，返回false
            if (find.indexOf(word.charAt(i)) < 0){
                result_boolean = false;
                break;
            }
        }
        return result_boolean;
    }
}
