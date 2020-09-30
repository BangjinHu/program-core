package ComRealQuestion.vmware;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class Phsyical {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            double n = sc.nextDouble();
            int m = sc.nextInt();
            double r = sc.nextDouble();
            double[][] ans = new double[m][2];

            int startX = 0, startY = 0, count = 0;
            int row = 0;
            //左->右
            if (startX < n){
                for (int i = startX; i < n; i++){
                    ++count;
                    if (count == r){
                        if (count > n){
                            ans[row][0] =  n;
                            ans[row][1] = count - n;
                        }else {
                            ans[row][0] = count;
                            ans[row][1] = 0;
                        }
                        row++;
                    }
                }
            }

            //下->上
            if (startY < n){
                for (int i = startY; i < n; i++){
                    ++count;
                    if (count == r){
                        if (count > n){
                            ans[row][0] =  n;
                            ans[row][1] = count - n;
                        }else {
                            ans[row][0] = count;
                            ans[row][1] = 0;
                        }
                        row++;
                    }
                }
            }

            //下->上
            if (startY < n){
                for (int i = startY; i < n; i++){
                    ++count;
                    if (count == r){
                        if (count > n){
                            ans[row][0] =  n;
                            ans[row][1] = count - n;
                        }else {
                            ans[row][0] = count;
                            ans[row][1] = 0;
                        }
                        row++;
                    }
                }
            }

            //下->上
            if (startY < n){
                for (int i = startY; i < n; i++){
                    ++count;
                    if (count == r){
                        if (count > n){
                            ans[row][0] =  n;
                            ans[row][1] = count - n;
                        }else {
                            ans[row][0] = count;
                            ans[row][1] = 0;
                        }
                        row++;
                    }
                }
            }
        }
    }
}
