package actual.JRWangluo;

import java.util.Scanner;

public class SortArrNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[] helper = new int[n];
            for (int i = 0; i < n; i++){
                int min = arr[i], count = 0;
                for (int k = 0; k < n; k++){
                    if (arr[k] < min){
                        count++;
                    }
                }
                helper[i] = count;
            }
            for (int i = 0; i < n; i++){
                System.out.print(helper[i] + " ");
            }
        }
    }
}
