package theory.strings;

public class minNums {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(minNums(nums));
    }

    public static String minNums(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    private static void quickSort(String[] strs, int left, int right) {
        if (left > right) {
            return;
        }
//        int m = left, n = right;
//        String tmp = strs[m];
//        while (left < right) {
//            while ((strs[n] + strs[m]).compareTo(strs[m] + strs[n]) >= 0 && m < n) {
//                n--;
//            }
//            while ((strs[n] + strs[m]).compareTo(strs[m] + strs[n]) <= 0 && m < n) {
//                m++;
//            }
//            tmp = strs[m];
//            strs[m] = strs[n];
//            strs[n] = tmp;
//        }
//        strs[m] = strs[left];
//        strs[left] = tmp;
//        quickSort(strs, left, m - 1);
//        quickSort(strs, m + 1, right);

        if (left < right) {
            swap(strs, left + (int) Math.random() * (right - left + 1), right);
            int less = left;
            int more = right;
            String leftNum = strs[left];
            while (left < more) {
                if (left < right && (leftNum + strs[right]).compareTo(strs[right] + leftNum) <= 0) {
                    swap(strs, ++less, left++);
                } else if (left < right && (leftNum + strs[right]).compareTo(strs[right] + leftNum) >= 0) {
                    swap(strs, --more, left);
                } else {
                    left++;
                }
            }
            swap(strs, more, right);
            int[] partition = new int[]{less + 1, more};
            quickSort(strs, left, partition[0] - 1);
            quickSort(strs, partition[1] + 1, right);
        }
    }

    private static void swap(String[] strs, int left, int right) {
        String str = strs[left];
        strs[left] = strs[right];
        strs[right] = str;
    }

}
