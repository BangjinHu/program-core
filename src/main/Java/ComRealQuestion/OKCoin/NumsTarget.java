package ComRealQuestion.OKCoin;

import java.util.Scanner;

public class NumsTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int target = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            int left = 0, right = arr.length - 1;
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (arr[mid] < target){
                    left = mid + 1;
                }else if (arr[mid] > target){
                    right = mid - 1;
                }else {
                    System.out.println(mid);
                    break;
                }
            }
//            System.out.println(-1);
        }
    }
}
