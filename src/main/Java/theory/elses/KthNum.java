package theory.elses;

//在两个排序数组中找到第k小的数
public class KthNum {

    public static void main(String[] args) {
        int[] shorts = new int[]{3,4,5};
        int[] longs = new int[]{1,2,3,4,5};
        System.out.println(kthNum(shorts, longs, 4));
    }

    public static int kthNum(int[] arrOne, int[] arrTwo, int kth) {
        if (arrOne == null || arrTwo == null){
            throw new RuntimeException("数组不合法");
        }

        if (kth < 1 || kth > arrOne.length + arrTwo.length){
            throw new RuntimeException("k值不合法");
        }

        int[] longs = arrOne.length > arrTwo.length ? arrOne : arrTwo;
        int[] shorts = arrOne.length > arrTwo.length ? arrTwo : arrOne;

        int lLen = longs.length;
        int sLen = shorts.length;
        UpMedianNum upMedianNum = new UpMedianNum();

        //k直接小于短数组的长度
        //那么直接在短数组中选k个数，在长数组中选k个数
        if (kth < sLen){
            return upMedianNum.upMedianNum(shorts, longs);
        }

        if (kth > lLen){
            //短数组中的数大于长数组中最大的数，这里是两个数组的叠加作用
            //短数组将长数组整体压在下面
            if (shorts[kth - lLen - 1] >= longs[lLen - 1]){
                return shorts[kth - lLen - 1];
            }

            //长数组将短数组整体压在下面
            if (longs[kth - sLen - 1] >= shorts[sLen - 1]){
                return longs[kth - sLen - 1];
            }

            //第三种情况，k值介于两个数组的值之间
            return upMedianNum.upMedianNum(shorts, longs);
        }

        if (longs[kth - sLen - 1] >= shorts[sLen - 1]){
            return longs[kth - sLen - 1];
        }

        return upMedianNum.upMedianNum(shorts, longs);
    }
}
