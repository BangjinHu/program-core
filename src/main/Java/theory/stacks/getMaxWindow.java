package theory.stacks;

import java.util.Arrays;
import java.util.LinkedList;

public class getMaxWindow {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,3,5,4,3,3,6,7};
        System.out.println(Arrays.toString(arr));
        int w = 3;
        Integer[] result = getMaxWindow(arr, w);
        System.out.println(Arrays.toString(result));
    }

    public static Integer[] getMaxWindow(Integer[] arr, int w){
        if (arr == null || w < 1 || arr.length < w){
            return null;
        }

        //1.创建双端队列
        LinkedList<Integer> qmax = new LinkedList<>();
        Integer[] result = new Integer[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            //2.如果队尾的数小于当前访问的数，弹出队尾数
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            //3.将i加入到qmax中
            qmax.addLast(i);

            //4.判断此时队头过期
            if (qmax.peekFirst() == i - w){
                //5.删除队头
                qmax.pollFirst();
            }

            //6.判断此时的i是否刚好达到窗口上限
            if (i >= w - 1){
                result[index++] = arr[qmax.peekFirst()];
            }
        }
        return result;
    }

}
