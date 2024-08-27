package theory.elses;

//表示调整[0,x)区间上的数出现的概率
public class RandXPowerK {

    public static void main(String[] args) {
        System.out.println(randXPower2());
        System.out.println(randXPowerK(10));
    }
    
    //返回两者之间的较大的随机数
    public static double randXPower2(){
        return Math.max(Math.random(), Math.random());
    }

    public static double randXPowerK(int k){
        if (k < 1){
            return 0;
        }

        double result = 0;
        //拿到k个random数中的最大值
        for (int i = 0; i < k; i++){
            result = Math.max(result, Math.random());
        }
        return result;
    }
}
