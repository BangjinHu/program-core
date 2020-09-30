package ComRealQuestion.Baidu;

import java.util.Scanner;

public class FinishGet {

    //钓鱼
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int t = sc.nextInt();

            sc.nextLine();
            double[][] rec = new double[n][m];
            for (int i = 0; i < n; i++){
                String[] contents = sc.nextLine().split(" ");
                for (int k = 0; k < m; k++){
                    rec[i][k] = Double.parseDouble(contents[k]);
                }
            }
            finishGet(rec, rec[x][y], t);
        }
    }

    private static void finishGet(double[][] rec, double cc, int t){
        double ss = 0;
        for (int i = 0; i < rec.length; i++){
            for (int k = 0; k < rec[0].length; k++){
                ss += rec[i][k];
            }
        }

        ss = ss / (rec.length * rec[0].length);
        if (ss > cc){
            System.out.println("ss");
            System.out.println(String.format("%.2f", 1 - Math.pow(1 - ss, t)));
        }else if (cc > ss){
            System.out.println("cc");
            System.out.println(String.format("%.2f", 1 - Math.pow(1 - cc, t)));
        }else {
            System.out.println("equal");
            System.out.println(String.format("%.2f", 1 - Math.pow(1 - cc, t)));
        }
    }
}
