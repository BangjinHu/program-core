package ComRealQuestion.WYHuyu;


import java.util.ArrayList;
import java.util.Scanner;

public class RotePrint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int k = 0; k < n; k++){
                    arr[i][k] = sc.nextInt();
                }
            }
            ArrayList<Integer> ansList = printMatrix(arr);
            for (int ans : ansList){
                System.out.print(ans + " ");
            }

        }
    }

    public static ArrayList<Integer> printMatrix(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) return result;
        int n = array.length, m = array[0].length;
        if(m==0) return result;
        int layers = (Math.min(n,m)-1)/2+1;//这个是层数
        for(int i=0;i<layers;i++){
            if (i % 2 == 0){
                for(int k = i;k< m-i;k++) result.add(array[i][k]);//左至右
                for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
                for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
                for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
            }else if (i % 2 == 1){
                for(int j = i; j < n-i; j++) result.add(array[j][i]);//左上到左下
                for(int k = i + 1; k < m-i; k++) result.add(array[i][k]);//左下到右下
                for(int j = n-i-1; j >= i && (n-i-1!=i); j--) result.add(array[j][m-i-1]);//右下至右上
                for(int k = m-i-1;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
            }
        }
        return result;
    }
}