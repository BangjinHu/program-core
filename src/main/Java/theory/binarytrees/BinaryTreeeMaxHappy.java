package theory.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeeMaxHappy {

    private static LinkedList<Employee> linkedList;
    private static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10};

    public static class Employee{
        public int happy;
        List<Employee> subs;
    }

    //每棵树处理完之后的返回值类型
    public static class ReturnData {
        //1.树的头节点来的情况下，整棵树的最大收益
        public int yesHeadMax;

        //2.树的头节点不来的情况下，整棵树的最大收益
        public int noHeadMax;

        public ReturnData(int yesHeadMax, int noHeadMax){
            this.noHeadMax = noHeadMax;
            this.yesHeadMax = yesHeadMax;
        }
    }

    //递归调用过程
    //该函数处理以X为头节点的树，并且返回X来和不来两种情况下的最大快乐值
    //所以返回值类型是ReturnData类型
    public static ReturnData process(Employee X){
        int yesX = X.happy;
        int noX = 0;

        //1.基层员工
        if (X.subs.isEmpty()){
            return new ReturnData(yesX, noX);
        }else {
            //2.枚举每一个直接下级员工next
            for (Employee next : X.subs){
                //3.递归调用process，得到以next为头节点的子树
                ReturnData subTreeInfo = process(next);
                //4.在next来或者不来分别得到两者的最大收益
                yesX += subTreeInfo.noHeadMax;
                noX += Math.max(subTreeInfo.yesHeadMax,subTreeInfo.noHeadMax);
            }
            return new ReturnData(yesX, noX);
        }
    }

    public int BinaryTreeMaxHappy(Employee boss){
        ReturnData allTreeInfo = process(boss);
        return Math.max(allTreeInfo.noHeadMax, allTreeInfo.yesHeadMax);
    }

    public static void main(String[] args) {

    }
}
