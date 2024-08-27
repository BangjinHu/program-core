package actual.WanmeiSJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SingleCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            Map<Character, Integer> charsMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++){
                charsMap.put(str.charAt(i), charsMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            StringBuilder sb = new StringBuilder();
            for (char c : charsMap.keySet()){
                if (charsMap.get(c) == 1){
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
