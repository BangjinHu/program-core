package actual.Xiaomi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SelectionStr {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            Map<Character, Integer> countCharacterMap = new HashMap<>();
            ArrayList<Character> ansList = new ArrayList<>();
            for (int i = 0; i < str.length(); i++){
                countCharacterMap.put(str.charAt(i), countCharacterMap.getOrDefault(str.charAt(i), 0) + 1);
                if (countCharacterMap.get(str.charAt(i)) == 1){
                    ansList.add(str.charAt(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : ansList){
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
