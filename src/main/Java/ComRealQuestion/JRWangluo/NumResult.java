package ComRealQuestion.JRWangluo;

import java.util.Scanner;

public class NumResult {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            /*int minUp = arr[0], upNum = 0, minDown = arr[n-1], downNum = 0;
            if(arr.length < 2){
                System.out.print(0);
            }
            for(int i = 1;i < arr.length; i++){
                if(arr[i] <= minUp){
                    minUp = arr[i];
                }else{
                    upNum++;
                }
            }
            for(int i = arr.length - 2; i >= 0; i--){
                if(arr[i] <= minDown){
                    minDown = arr[i];
                }else{
                    downNum++;
                }
            }
            System.out.print(Math.min(downNum, upNum));*/

            int min = Integer.MAX_VALUE, minIndex = 0;
            for (int i = 0; i < n; i++){
                if (arr[i] < min){
                    min = arr[i];
                    minIndex = i;
                }
            }
            int minindex = 1, maxindex = 1, minCount = 0, maxCount = 0;
            //从大到小排
            while (minindex < arr.length){
                if (arr[minindex] > arr[minindex-1] && minindex < minIndex){
                    minCount++;
                }else if (arr[minindex] < arr[minindex-1] && minindex > minIndex){
                    minCount++;
                }
                minindex++;
            }
            //从小到大排
            while (maxindex < arr.length){
                if ((arr[maxindex] > min || arr[maxindex] < arr[maxindex-1]) && maxindex < minIndex){
                    maxCount++;
                }else if (arr[maxindex] < arr[maxindex-1] && maxindex > minIndex){
                    maxCount++;
                }
                maxindex++;
            }
            System.out.println(Math.min(maxCount, minCount));
        }
    }
}
