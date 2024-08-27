package actual.QNar;

import java.util.*;

public class KingQueueSelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String[] inStr = new String[n];
            for (int i = 0; i < n; i++){
                inStr[i] = sc.next();
            }
            Map<Character, String> colorAndValueMap = new HashMap<>();
            for (int i = 0; i < n; i++){
                colorAndValueMap.put(inStr[i].charAt(0), inStr[i].substring(1));
            }
            System.out.println(isJudge(colorAndValueMap));
        }
    }

    private static String isJudge(Map<Character, String> inMap){

        int sCount = 0, hCount = 0, cCount = 0, dCount = 0;
        for (char k : inMap.keySet()){
            if (k == 'S'){
                sCount++;
            }
            if (k == 'H'){
                hCount++;
            }
            if (k == 'C'){
                cCount++;
            }
            if (k == 'D'){
                dCount++;
            }
        }
        ArrayList<Integer> valuesList = new ArrayList<>();
        for (String v : inMap.values()){
            if (v == "A"){
                v = "1";
            }
            if (v == "J"){
                v = "11";
            }
            if (v == "Q"){
                v = "12";
            }
            if (v == "K"){
                v = "13";
            }
            valuesList.add(Integer.parseInt(v));
        }
        Collections.sort(valuesList);
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> pointMap = new HashMap<>();
        for (int i = 0; i < valuesList.size(); i++){
            pointMap.put(valuesList.get(i), pointMap.getOrDefault(valuesList.get(i), 0) + 1);
        }
        for (int i = 1; i < valuesList.size(); i++){
            countMap.put(valuesList.get(i) - valuesList.get(i-1), countMap.getOrDefault(valuesList.get(i) - valuesList.get(i-1), 0) + 1);
        }
        for (int i = 0; i < valuesList.size(); i++){
            if (countMap.size() == valuesList.size()
                    && (dCount == valuesList.size()
                    || cCount == valuesList.size()
                    || sCount == valuesList.size()
                    || hCount == valuesList.size())){
                if (valuesList.contains(13)){
                    return "HuangJiaTongHuaShun";
                }
                return "TongHuaShun";
            }else if (pointMap.get(valuesList.get(i)) == 4){
                return "SiTiao";
            }else if (pointMap.get(valuesList.get(i)) == 3){
                int tmp = 0;
                if (valuesList.get(i) != valuesList.get(i-1)){
                    tmp = valuesList.get(i-1);
                }
                if (pointMap.get(tmp) == 2){
                    return "HuLu";
                }
            }else if (dCount == valuesList.size()
                    || cCount == valuesList.size()
                    || sCount == valuesList.size()
                    || hCount == valuesList.size()){
                return "TongHua";
            }else if (countMap.size() == valuesList.size()){
                return "ShunZi";
            }else if (pointMap.get(valuesList.get(i)) == 3){
                return "SanTiao";
            }else if (pointMap.get(valuesList.get(i)) == 2){
                int tmp = 0;
                if (valuesList.get(i) != valuesList.get(i-1)){
                    tmp = valuesList.get(i-1);
                }
                if (pointMap.get(tmp) == 2){
                    return "LiangDui";
                }
            }else if (pointMap.get(valuesList.get(i)) == 2){
                return "YiDui";
            }
        }
        return "GaoPai";
    }
}
