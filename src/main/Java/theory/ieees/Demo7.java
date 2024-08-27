package theory.ieees;

public class Demo7 {

    public static void main(String[] args) {
        String str = "CBBACC";
        System.out.println(maxUnique(str));
    }

    public static int maxUnique(String str){
        if (str == null || str.equals("")){
            return 0;
        }

        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++){
            map[i] = -1;
        }

        int count = 0;
        for (int i = 0; i < chas.length - 1; i++){

            if (chas[i] == chas[i+1] || chas[0] == chas[chas.length-1]){
                continue;
            }else {
                for (int j = 0; j < chas.length; j++){
                    if (chas[j] == chas[i]){
                        swap(chas[i+1], chas[j]);
                    }
                }
                count++;
            }
        }
        return count;
    }

    private static void swap(int x, int y){
        int t = x;
        x = y;
        y = t;
    }

}
