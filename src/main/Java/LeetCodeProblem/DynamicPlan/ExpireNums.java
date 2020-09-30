package LeetCodeProblem.DynamicPlan;

public class ExpireNums {

    public static void main(String[] args) {

        expireNums();

        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println(maxMemory / 1024 / 1024 + "m");
        System.out.println(totalMemory / 1024 / 1024 + "m");

    }

    public static int expireNums(){
        int result = 0;
        for (int i = 0; i < 1000; i++){
            result++;
            System.out.println(i);
        }
        return result;
    }
}
