package LeetCodeProblem.Array_Problem;

public class UniqueTriad {
    public static void main(String[] args) {
        int[] arr = new int[]{-8,-4,-3,0,1,2,4,5,8,9};
        UniqueTriad(arr, 10);
        System.out.println();
    }

    public static void UniqueTriad(int[] arr, int K){
        if (arr == null || arr.length == 0){
            return;
        }

        for (int i = 0; i < arr.length; i++){
            //三元组的第一个元素不重复
            if (i == 0 || arr[i] != arr[i-1]){
                //三元组的情况就是在二元组的情况下在前面加上一元素
                uniqueUnit(arr, i, i+1, arr.length-1, K-arr[i]);
            }
        }
    }

    public static void uniqueUnit(int[] arr, int f, int l, int r, int k){
        while (l < r){
            //小于k的值，二元组的情况
            if (arr[l] + arr[r] < k){
                l++;
            }else if (arr[l] + arr[r] > k){
                r--;
            }else {
                //这儿的l=f+1或者没有重复的值出现就输出
                if (l == f + 1 || arr[l-1] != arr[l]){
                    System.out.println(arr[f] + "," + arr[l] + "," + arr[r]);
                }
                l++;
                r--;
            }
        }
    }
}
