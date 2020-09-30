package LeetCodeProblem.Else_Problem;

public class Rand1To7 {

    public static void main(String[] args) {
        System.out.println(rand1To7());
    }

    public static int rand1To5(){
        return (int) (Math.random() * 5 + 1);
    }

    //基于1->5的随机数得到1->7的随机数
    public static int rand1To7(){
        int num = 0;
        do {
            //得到0-24的随机数
            num = (rand1To5() - 1) * 5 + rand1To5() - 1;
        }while (num > 20);

        //然后得到1-7的随机数
        return num % 7 + 1;

    }
}
