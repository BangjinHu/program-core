package theory.elses;

public class Rand1ToN {

    public static void main(String[] args) {

        System.out.println(rand1ToN(10, 12));

    }

    //1.生成1-m的随机数
    public static int rand1ToM(int m){
        return (int) (Math.random() * m + 1);
    }

    //2.生成1-n的随机数
    public static int rand1ToN(int n, int m){
        int[] nMSys = getMSysNum(n-1, m);
        int[] randNum = getRanMSysNumLessN(nMSys, m);
        return getNumFromMSysNum(randNum, m) + 1;
    }

    //3.进制转换
    public static int[] getMSysNum(int value, int m){
        //将value转换成m进制数
        int[] result = new int[32];
        int index = result.length - 1;
        while (value != 0){
            result[index--] = value % m;
            value = value / m;
        }
        return result;
    }

    //4.用m进制表达，随机产生一个0-nMSys范围的数
    public static int[] getRanMSysNumLessN(int[] nMSys, int m){
        int[] result = new int[nMSys.length];
        int start = 0;
        while (nMSys[start] == 0){
            start++;
        }

        int index = start;
        boolean lastEqual = true;
        while (index != nMSys.length){
            result[index] = rand1ToM(m) - 1;
            if (lastEqual){
                if (result[index] > nMSys[index]){
                    index = start;
                    lastEqual = true;
                    continue;
                }else {
                    lastEqual = result[index] == nMSys[index];
                }
            }
            index++;
        }
        return result;
    }

    //6.将m进制转换成十进制
    public static int getNumFromMSysNum(int[] mSysNum, int m){
        int result = 0;
        for (int i = 0; i != mSysNum.length; i++){
            result = result * m + mSysNum[i];
        }
        return result;
    }
}
