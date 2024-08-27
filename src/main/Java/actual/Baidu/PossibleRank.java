package actual.Baidu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PossibleRank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
            int[] u = new int[m];
            int[] v = new int[m];
            for (int i = 0; i < m; i++){
                u[i] = sc.nextInt();
                v[i] = sc.nextInt();
            }
            List<Integer> rankList = new ArrayList<>();
            int r = 0;
            for (int i = 0; i < m; i++){
                if (u[i] != p){
                    continue;
                }else {
                    r = i;
                }
            }
            for (int i = 0; i < m; i++){
                rankList.add(v[r]);
                if (v[i] == v[r]){
                    rankList.add(v[i]);
                    v[r] = v[i];
                }else {
                    continue;
                }
            }
            Collections.sort(rankList);
            for (int i = 0; i < rankList.size(); i++){
                System.out.print(rankList.get(i) + " ");
            }
        }
    }
}
