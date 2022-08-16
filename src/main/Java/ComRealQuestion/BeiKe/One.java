package ComRealQuestion.BeiKe;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            String[] fhars = new String[2];
            String[] rhars = new String[2];
            for(int i = 0; i < 2; i++){
                fhars[i] = in.next();
            }
            for(int i = 0; i < 2; i++){
                rhars[i] = in.next();
            }
            int lcount = 0, rcount = 0;
            for(int i = 0; i < 2; i++){
                for(int k = 0; k < 2; k++){
                    if(fhars[i] != rhars[k]){
                        if((fhars[i] == "J" && rhars[k] == "B")
                                || (fhars[i] == "B" && rhars[k] == "S"
                                || (fhars[i] == "S" && rhars[k] == "J"))){
                            lcount++;
                        }else if((rhars[i] == "J" && fhars[k] == "B")
                                || (rhars[i] == "B" && fhars[k] == "S"
                                || (rhars[i] == "S" && fhars[k] == "J"))){
                            rcount++;
                        }
                    }
                }
            }
            double ans = 0;
            if((ans = (double)lcount / 4) > 0.5){
                System.out.println("left");
            }else if((ans = (double)rcount / 4) < 0.5){
                System.out.println("right");
            }else if((ans = (double)lcount / 4) == (ans = (double)rcount / 4)){
                System.out.println("same");
            }
        }
    }
}
