package theory.strings;

/**
 * 判断字符数组中的所有字符是否都只出现一次
 */
public class isUniquel {
    public static void main(String[] args) {
        char[] chas = new char[]{'1', '2', '3'};
        System.out.println(isUniquel(chas));
        System.out.println(isUniquel2(chas));
    }

    public static boolean isUniquel(char[] chas){
        if (chas == null){
            return true;
        }

        boolean[] map = new boolean[256];
        for (int i = 0; i < chas.length; i++){
            if (map[chas[i]]){
                return false;
            }
            map[chas[i]] = true;
        }
        return true;
    }

    public static boolean isUniquel2(char[] chas){
        if (chas == null){
            return true;
        }

        heapSort(chas);
        for (int i = 1; i < chas.length; i++){
            if (chas[i] == chas[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void heapSort(char[] chas){
        for (int i = 0; i < chas.length; i++){
            heapInsert(chas, i);
        }

        for (int i = chas.length-1; i > 0; i--){
            swap(chas, 0, i);
            heapify(chas, 0, i);
        }
    }

    public static void heapInsert(char[] chas, int i){
        int parent = 0;
        while(i != 0){
            parent = (i-1)/2;
            if (chas[parent] < chas[i]){
                swap(chas, parent, i);
                i = parent;
            }else {
                break;
            }
        }
    }

    public static void heapify(char[] chas, int i, int size){
        int left = i*2 + 1;
        int right = i*2 + 2;
        int largest = i;
        while(left < right){
            if (chas[left] > chas[right]){
                largest = left;
            }
            if (right < size && chas[right] > chas[largest]){
                largest = right;
            }else {
                break;
            }

            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
    }

    public static void swap(char[] chas, int index1, int index2){
        char temp = chas[index1];
        chas[index1] = chas[index2];
        chas[index2] = temp;
    }
}
