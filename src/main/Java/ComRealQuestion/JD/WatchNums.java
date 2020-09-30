package ComRealQuestion.JD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WatchNums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[2 * n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                arr[i + n] = arr[i];
            }
            int max = 0, smax = 0;
            for (int i = 1; i < n; i++){
                //数组中的最大值
                if (arr[max] < arr[i]){
                    max = i;
                }
            }
            //max下标值是0
            if (max == 0){
                smax = 1;
            }
            for (int i = 1; i < n; i++){
                if (i == max){
                    continue;
                }
                //统计次大值
                if (arr[smax] < arr[i]){
                    smax = i;
                }
            }
            int start = max > smax ? smax : max;
            int mid = max > smax ? max : smax;
            int end = start + n;
            System.out.println(getCount(arr, start, mid) + getCount(arr, mid, end) + 1);
        }
    }

    private static long getCount(int[] arr, int start, int end) {
        if (end - start == 1){
            return 0;
        }
        List<Integer> list = getMaxIdxExceptStartAndEnd(arr, start, end);
        long c = list.size();
        int f = list.get(0);
        int l = list.get(list.size() - 1);
        long r1 = getCount(arr, start, f) + c;
        long r2 = getCount(arr, l, end) + c;
        long sumOne = c * (c - 1) / 2;
        for (int i = 1; i < list.size(); i++){
            sumOne += getCount(arr, list.get(i-1), list.get(i));
        }
        return r1 + r2 + sumOne;
    }

    //
    private static List<Integer> getMaxIdxExceptStartAndEnd(int[] arr, int start, int end) {
        List<Integer> list = new ArrayList<Integer>();
        int max = start+1;
        list.add(max);
        for(int i = start+2; i < end; i++){
            if(arr[max] < arr[i]){
                list.clear();
                list.add(i);
                max = i;
            }else if(arr[max] == arr[i]){
                list.add(i);
            }
        }
        return list;
    }
}
