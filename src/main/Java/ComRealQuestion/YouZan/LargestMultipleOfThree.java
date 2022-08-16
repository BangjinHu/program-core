package ComRealQuestion.YouZan;

import java.util.*;

public class LargestMultipleOfThree {

    public static void main(String[] args) {
        ArrayList<Integer> digits = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            digits.add(sc.nextInt());
            System.out.println(largestMultipleOfThree(digits));
        }
    }

    public static String largestMultipleOfThree(ArrayList<Integer> digits) {
        // write code here
        List<Integer>[] ansArr = new List[3];
        for(int i = 0; i < 3; i++){
            ansArr[i] = new ArrayList<>();
        }
        int sum = 0;
        for(int i : digits){
            ansArr[i % 3].add(i);
            sum += i;
        }
        for(int i = 0; i < 3; i++){
            Collections.sort(ansArr[i], Collections.reverseOrder());
        }
        int flag = sum % 3;
        if(flag != 0){
            if(ansArr[flag].size() > 0){
                ansArr[flag].remove(ansArr[flag].size() - 1);

            }else if(ansArr[3-flag].size() > 1){
                ansArr[3-flag].remove(ansArr[3-flag].size() - 1);
                ansArr[3-flag].remove(ansArr[3-flag].size() - 1);
            }else {
                ansArr[1].clear();
                ansArr[2].clear();
            }
        }
        ansArr[0].addAll(ansArr[1]);
        ansArr[0].addAll(ansArr[2]);
        Collections.sort(ansArr[0], Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int m : ansArr[0]){
            sb.append(m);
        }
        if(sb.length() != 0 && sb.charAt(0) == '0'){
            return "0";
        }
        return sb.toString();
    }
}