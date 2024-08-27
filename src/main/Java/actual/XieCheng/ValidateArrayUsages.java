/*
package ComRealQuestion.XieCheng;

import java.util.Scanner;

*/
/**
 * 题目描述：
 * 作为一个新手程序员，数组越界是一个非常容易犯的错误。游游为了提醒自己，决定写一个小程序来分析自己的代码中是否存在这样的错误。但它很快发现，这项工作对于它来说太过困难了。所以它希望你来帮忙实现一个简化后的版本。
 *
 * 在这个简化后的版本中，它所需要处理的语句只有以下两种类型：
 *
 * 1. 整形数组定义语句：格式为name[size]。例如：a[5]或者array[10]。数组可用的下标为[0, size)。定义后的数组所有的元素均为0；
 *
 * 2. 赋值语句：格式为name[index]=value。例如：a[0]=1或者a[a[0]]=a[a[3]]。
 *
 * 在被分析的代码中，数组越界错误只会出现在赋值语句中，且代码中只会有这一类错误。游游希望你帮它找出代码中第一次出现错误的语句，并输出对应的行号。
 *//*

public class ValidateArrayUsages {

    static int validateArrayUsages(String[] lines) {


    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _lines_size = 0;
        _lines_size = Integer.parseInt(in.nextLine().trim());
        String[] _lines = new String[_lines_size];
        String _lines_item;
        for(int _lines_i = 0; _lines_i < _lines_size; _lines_i++) {
            try {
                _lines_item = in.nextLine();
            } catch (Exception e) {
                _lines_item = null;
            }
            _lines[_lines_i] = _lines_item;
        }
        res = validateArrayUsages(_lines);
        System.out.println(String.valueOf(res));
    }
}
*/
