package actual.JD;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class SetSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            /*int[] arrSetF = new int[n];
            int[] arrSetS = new int[m];
            //合并两个数组，从小到大排序
            for (int i = 0; i < n; i++){
                arrSetF[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++){
                arrSetS[i] = sc.nextInt();
            }
            int[] helper = new int[m + n];
            int length = helper.length;
            while ((length--) > 0){
                int i = 0, k = 0;
                if (arrSetF[i++] < arrSetS[k++] && i < n && k < m){
                    helper[i] = arrSetF[i];
                }else if (arrSetF[i++] > arrSetS[k++] && i < n && k < m) {
                    helper[i] = arrSetS[k];
                }
            }
            for (int i = 0; i < helper.length; i++){
                System.out.print(helper[i] + " ");
            }*/

            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++){
                treeSet.add(sc.nextInt());
            }
            for (int i = 0; i < m; i++){
                treeSet.add(sc.nextInt());
            }
            Iterator it = treeSet.iterator();
            while (it.hasNext()){
                int index = 0;
                if (index == treeSet.size() - 1){
                    System.out.println(it.next());
                }else {
                    System.out.println(it.next() + " ");
                }
            }
        }
    }
}
