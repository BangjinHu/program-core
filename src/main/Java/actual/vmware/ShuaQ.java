package actual.vmware;

//import java.util.Scanner;
//
//public class ShuaQ {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int t = sc.nextInt();
//            while ((t--) > 0){
//                int n = sc.nextInt();
//                int[] scolor = new int[n];
//                int[] ecolor = new int[n];
//                for (int i = 0; i < n; i++){
//                    scolor[i] = sc.nextInt();
//                }
//                for (int i =0; i < n; i++){
//                    ecolor[i] = sc.nextInt();
//                }
//
//
//                for (int i = 1; i < n; i++){
//                    if (scolor[i] != ecolor[i]){
//                        if (ecolor[i] == scolor[i-1] || ecolor[i] == scolor[i+1]){
//                            System.out.println("YES");
//                        }
//                    }else {
//                        System.out.println("NO");
//                    }
//                }
//            }
//        }
//    }
//}

import java.util.*;

public class ShuaQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            // 每一组
            String[] nums_from = sc.nextLine().split(" ");
            String[] nums_to = sc.nextLine().split(" ");
            int index = 0;
            int flag = 0;
            for (int j = 0; j < m; j++) {
                // 新墙的每一块
                if(j==0 || !nums_to[j].equals(nums_to[j-1])) {
                    flag = 0;
                    for (int k = index; k < m; k++) {
                        // 老墙的每一块
                        if(nums_from[k].equals(nums_to[j])) {
                            // 找到老墙与新墙对应的index 开始下一个新墙
                            flag = 1;
                            index = k+1;
                            break;
                        }
                    }
                }
            }
            if(flag == 1) {
                System.out.println("YES");
            }
            if(flag == 0) {
                System.out.println("NO");
            }
        }
    }
}
