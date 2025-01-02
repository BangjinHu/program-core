package theory.arrays;

public class MergeArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 5, 6};
        int[] arr2 = new int[]{1, 2, 3, 0, 0, 0};
        int[] res = mergeArr(arr1, arr2);
        for (int curNum : res) {
            System.out.print(curNum + " ");
        }
    }

    private static int[] mergeArr(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        int m2 = m - n;
        int index = m;
        while (index > 0) {
            if (arr1[n - 1] > arr2[m2 - 1]) {
                arr2[--index] = arr1[n];
                n--;
            } else {
                arr2[--index] = arr2[m2];
                m2--;
            }
        }
        return arr2;
    }
}
