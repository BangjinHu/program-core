package ComRealQuestion.JD;

import java.util.Scanner;

public class GetYears {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            /*String ans = "";
            int count = 0;
            int start = 1;
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    if (start != 1){
                        ans += "";
                    }else {
                        start = 0;
                    }
                    ans += str.charAt(i-3) + str.charAt(i-2) + str.charAt(i-1) + str.charAt(i);

                }
                if (count == 4){
                    if ((str.charAt(i) >= '0' && str.charAt(i) <= '9') == false){
                        if (start != 1){
                            ans += "";
                        }else {
                            start = 0;
                        }
                        ans += str.charAt(i-4) + str.charAt(i-3) + str.charAt(i-2) + str.charAt(i-1);
                    }
                    count = 0;
                }else if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    if (count == 0){
                        if (str.charAt(i) >= '1' && str.charAt(i) <= '3'){
                            count += 1;
                        }else {
                            count = 0;
                        }
                    }else {
                        count += 1;
                    }
                }else {
                    count = 0;
                }
            }
            System.out.println(ans);*/

            String[] strs = str.split(" ");
            for (int i = 0; i < strs.length; i++){
                if (strs[i].length() < 4){
                    System.out.println(-1);
                }
                for (int k = 0; k < strs.length; k++){
                    
                }

            }
        }
    }
}
