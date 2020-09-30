package ComRealQuestion.Bytedance;

import java.util.Scanner;

public class XorNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            //暴力超时
            /*int count = 0;
            for (int i = 0; i < n; i++){
                for (int k = i + 1; k < n; k++){
                    if ((arr[i] ^ arr[k]) > m){
                        count++;
                    }
                }
            }
            System.out.println(count);*/

            //字典树
            System.out.println(xorNum(arr, m));
        }
    }

    private static long xorNum(int[] arr, int m) {
        TrieTree trieTree = buildTrieTree(arr);
        long ans = 0;
        for (int i = 0; i < arr.length; i++){
            ans += findTrieTree(trieTree, arr[i], m, 31);
        }
        return ans / 2;
    }

    private static long findTrieTree(TrieTree trieTree, int x, int m, int index) {
        if (trieTree == null){
            return 0;
        }
        TrieTree cur = trieTree;
        for (int i = index; i >= 0; i--){
            int xDigit = (x >> i) & 1;
            int mDigit = (m >> i) & 1;
            if (xDigit == 1 && mDigit == 1){
                if (cur.next[0] == null){
                    return 0;
                }
                cur = cur.next[0];
            }else if (xDigit == 0 && mDigit == 1){
                if (cur.next[1] == null){
                    return 0;
                }
                cur = cur.next[1];
            }else if (xDigit == 1 && mDigit == 0){
                long p = findTrieTree(cur.next[1], x, m, i - 1);
                long q = cur.next[0] == null ? 0 : cur.next[0].count;
                return p + q;
            }else if (xDigit == 0 && mDigit == 0){
                long p = findTrieTree(cur.next[0], x, m, i - 1);
                long q = cur.next[1] == null ? 0 : cur.next[1].count;
                return p + q;
            }
        }
        return 0;
    }

    private static TrieTree buildTrieTree(int[] arr) {

        TrieTree trieTree = new TrieTree();
        for (int i = 0; i < arr.length; i++){
            TrieTree cur = trieTree;
            for (int k = 31; k >= 0; k--){
                int digit = (arr[i] >> k) & 1;
                if (cur.next[digit] == null){
                    cur.next[digit] = new TrieTree();
                }else {
                    cur.next[digit].count++;
                }
                cur = cur.next[digit];
            }
        }
        return trieTree;
    }

    static class TrieTree {
        TrieTree[] next = new TrieTree[2];
        int count = 1;
    }
}
