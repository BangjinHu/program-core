package ComRealQuestion.Baidu;

import java.util.HashSet;
import java.util.Scanner;

public class StrPattern {
    //字符串匹配
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String p = sc.nextLine();
            char[] chars = str.toCharArray();
            char[] pchars = p.toCharArray();
            HashSet<String> hset = new HashSet<>();
            for(int i = 0; i <= chars.length - pchars.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < pchars.length; k++){
                    if(pchars[k] == '?' || pchars[k] == chars[i+k]){
                        sb.append(chars[i+k]);
                    }
                }
                if(sb.toString().length() == pchars.length){
                    hset.add(sb.toString());
                }
            }
            System.out.println(hset.size());
        }
    }
}
