package theory.elses;

//从N个数中等概率打印M个数
public class RandMOut {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        randMOut(arr, 4);
    }

    //表示从数组arr中等概率打印m个不重复的数
    public static void randMOut(int[] arr, int m){
        if (arr == null || arr.length == 0){
            return;
        }

        //这里m取值较小的那个数
        m = Math.min(arr.length, m);
        int count = 0;
        int i = 0;
        while (count < m){
            i = (int) (Math.random() * (arr.length - count));
            System.out.println(arr[i]);
            //将打印之后的数与数组的末尾位置的数交换位置
            swap(arr, arr.length - count++ - 1, i);
        }
    }

    //交换两个数的位置
    public static void swap(int[] arr, int indexOne, int indexTwo){
        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
}
