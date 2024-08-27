package theory.strings;

public class getIndex {
    public static void main(String[] args) {
        String[] strs = new String[]{null, "a", "b", null};
        System.out.println(getIndex(strs, "b"));
    }

    public static int getIndex(String[] strs, String str){
        if (strs == null || strs.length == 0 || str == null){
            return -1;
        }

        int result = -1;
        int left = 0;
        int right = strs.length - 1;
        int mid = 0;
        int i = 0;
        while(left < right){
            //1.首先找到数组中的mid位置
            mid = (left + right) / 2;

            //2.如果找的字符刚好是mid位置的字符，且需要找最左的，所以还需要找左半区中该字符最靠左的位置
            if (strs[mid] != null && strs[mid].equals(str)){
                result = mid;
                right = mid - 1;
            }else if (strs[mid] != null){
                //3.字符串中点位置的字符小于要找字符
                if (strs[mid].compareTo(str) < 0){
                    left = mid + 1;
                }else {
                    //4.字符串中点位置字符大于要找字符
                    right = mid - 1;
                }
            }else {
                //5.这里表示
                i = mid;
                while (strs[i] == null && --i >= left);
                if (i < left || strs[i].compareTo(str) < 0){
                    left = mid + 1;
                }else {
                    result = strs[i].equals(str) ? i : result;
                    right = i - 1;
                }
            }
        }
        return result;
    }
}
