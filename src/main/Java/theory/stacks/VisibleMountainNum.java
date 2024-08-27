package theory.stacks;

import java.util.Stack;

public class VisibleMountainNum {

    public class Record {
        public int value;
        public int times;

        public Record(int value) {
            this.value = value;
            this.times = 1;
        }
    }

    public int visibleMountainNum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }

        int size = arr.length;
        int maxIndex = 0;

        //1.首先在环中找到最大值，随便一个都行
        for (int i = 0; i < arr.length; i++){
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }

        Stack<Record> stack = new Stack<>();
        //2.将最大值记录放入stack中
        stack.push(new Record(arr[maxIndex]));
        //3.从最大值位置的下一个位置开始沿next方向遍历
        int index = nextIndex(maxIndex, size);
        //4.小找大的方式统计所有可见山峰对
        int result = 0;
        //5.遍历阶段
        while (index != maxIndex){
            while (stack.peek().value < arr[index]){
                int k = stack.pop().times;
                result += getInternalSum(k) + 2 * k;
            }

            if (stack.peek().value == arr[index]){
                stack.peek().times++;
            }else {
                stack.push(new Record(arr[index++]));
            }

            index = nextIndex(index, size);
        }

        //6.清算阶段
        while (stack.size() > 2){
            int times = stack.pop().times;
            result += getInternalSum(times) + 2 * times;
        }

        if (stack.size() == 2){
            int times = stack.pop().times;
            result += getInternalSum(times) + (stack.peek().times == 1 ? times : 2 * times);
        }

        result += getInternalSum(stack.pop().times);
        return result;
    }

    //番外
    public int getInternalSum(int k){
        return k == 1 ? 0 : (k * (k - 1) / 2);
    }

    public int nextIndex(int i, int size){
        return i < (size - 1) ? (i + 1) : 0;
    }
}
