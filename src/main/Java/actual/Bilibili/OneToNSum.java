package actual.Bilibili;

import java.util.Scanner;

//求1到n中数之和等于n的个数
public class OneToNSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int left = 1, right = 2, count = 0, ansSum = 0, index = 2;
            if(ansSum < n){
                ansSum = (left + right) * index / 2;
                index++;
                right++;
            }else if(ansSum == n){
                count++;
                left += 1;
                right = left + 1;
                index = 2;
            } else {
                left += 1;
                right = left+1;
                index = 2;
            }
            System.out.println(count+1);
        }
    }
}
