package theory.elses;

public class KNumsRand {

    public static void main(String[] args) {

        int k = 10;
        int max = 2;
        for (int i = 0; i < kNumsRand(k, max).length; i++){
            System.out.println(kNumsRand(k, max)[i]);
        }
    }

    public static int rand(int max){
        return (int) (Math.random() * max + 1);
    }

    public static int[] kNumsRand(int k, int max){
        if (max < 1 || k < 1){
            return null;
        }

        int[] result = new int[Math.min(k, max)];
        for (int i = 0; i != result.length; i++){
            result[i] = i + 1;
        }

        for (int i = k + 1; i < max + 1; i++){
            if (rand(i) <= k){
                result[rand(k) - 1] = i;
            }
        }
        return result;
    }
}
